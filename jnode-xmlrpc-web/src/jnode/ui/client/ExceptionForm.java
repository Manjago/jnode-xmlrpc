package jnode.ui.client;

import com.google.gwt.user.client.ui.HTML;
import com.sencha.gxt.widget.core.client.ContentPanel;
import com.sencha.gxt.widget.core.client.Dialog;
import com.sencha.gxt.widget.core.client.Dialog.PredefinedButton;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer;
import com.sencha.gxt.widget.core.client.container.VerticalLayoutContainer.VerticalLayoutData;
import com.sencha.gxt.widget.core.client.form.TextArea;
import jnode.ui.client.Helper;
import jnode.ui.client.ui.sys.CommonDialog;

public class ExceptionForm extends CommonDialog {

	private static final int FORM_WIDTH = 600;
	private static final int ADMIN_INFO_PANEL_HEIGHT = 150;

	public ExceptionForm(String header, String textForUser, String textForAdmin) {
		super(header);

		HTML userInfo = new HTML(
				"<div class=text style='padding:25px 5px'> <center><b>"
						+ textForUser + "</b></center></div>");

		TextArea info = createAdminTextArea(textForAdmin);

		ContentPanel adminInfoPanel = createAdminInfoPanel();
		adminInfoPanel.setWidget(info);

		addChild(userInfo, new VerticalLayoutData(1, -1));
		addChild(adminInfoPanel, new VerticalLayoutData(1, 1));
	}

	@Override
	protected void tune(Dialog widget, VerticalLayoutContainer container) {
		super.tune(widget, container);
		widget.setPredefinedButtons(PredefinedButton.CLOSE);
		widget.setWidth(FORM_WIDTH);
		widget.setBodyStyle("backgroundColor: red;");		
		
	}

	private TextArea createAdminTextArea(String textForAdmin) {
		TextArea info = new TextArea();
		info.setAllowTextSelection(false);
		info.setValue(textForAdmin);
		return info;
	}

	private ContentPanel createAdminInfoPanel() {
		ContentPanel panel = new ContentPanel();
		panel.setHeadingText(Helper.CONSTANTS.errorDetailsCaption());
		panel.setCollapsible(true);
		panel.collapse();
		panel.setHeight(ADMIN_INFO_PANEL_HEIGHT);
		return panel;
	}

}
