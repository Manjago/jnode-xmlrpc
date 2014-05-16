package jnode.ui.client.ui.sys;

import com.google.gwt.core.client.Scheduler;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
import com.google.gwt.user.client.ui.IsWidget;
import com.sencha.gxt.widget.core.client.Component;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.event.DialogHideEvent;
import jnode.ui.shared.Lambda;

public abstract class CommonDialog implements IsWidget {

    private final Dialog widget;
    private final VerticalLayoutContainer outer;
    private String caption;
    private boolean inited;
    private Component focusedAfterShow;

    private Lambda<PredefinedButton, Void> onCloseCommand;

    public CommonDialog() {
        widget = new Dialog();
        widget.addDialogHideHandler(new DialogHideEvent.DialogHideHandler() {
            @Override
            public void onDialogHide(DialogHideEvent dialogHideEvent) {
                if (onCloseCommand != null) {
                    onCloseCommand
                            .execute(dialogHideEvent.getHideButton());
                }

            }
        });
        outer = new VerticalLayoutContainer();
    }

    public CommonDialog(String caption) {
        this();
        this.caption = caption;
    }

    protected void tune(Dialog widget, VerticalLayoutContainer container) {
        widget.setHeaderVisible(true);
        widget.setHeadingHtml("<span style=\"color : black;\">" + caption + "</span>");
        widget.setModal(true);
        widget.setHideOnButtonClick(true);
        widget.setBodyStyleName("pad-text");
        widget.getBody().addClassName("pad-text");
    }

    public void addChild(IsWidget child) {
        outer.add(child);
    }

    public void addChild(IsWidget child, VerticalLayoutData layoutData) {
        outer.add(child, layoutData);
    }

    public Dialog asWidget() {
        init();
        return widget;
    }

    public void init() {
        if (!inited) {
            tune(widget, outer);
            widget.setWidget(outer);
            inited = true;
        }
    }

    public void show() {
        asWidget().show();
        Scheduler.get().scheduleDeferred(new ScheduledCommand() {

            public void execute() {
                if (getFocusedAfterShow() != null) {
                    getFocusedAfterShow().focus();
                }
            }
        });
    }

    public Lambda<PredefinedButton, Void> getOnCloseCommand() {
        return onCloseCommand;
    }

    public void setOnCloseCommand(Lambda<PredefinedButton, Void> onCloseCommand) {
        this.onCloseCommand = onCloseCommand;
    }

    protected Component getFocusedAfterShow() {
        return focusedAfterShow;
    }

    protected void setFocusedAfterShow(Component focusedAfterShow) {
        this.focusedAfterShow = focusedAfterShow;
    }

}
