package caozhilong.github.io.book.ch2;

import org.eclipse.swt.SWT;
import org.eclipse.swt.events.*;
import org.eclipse.swt.widgets.*;

public class HelloSWT extends Shell {
	private static Text text;
	private static Button swtButton;
	private static Button swingButton;
	private static Button awtButton;
	private static Group group;
	private static Button button;
	private static Label benefitOfSwtLabel;
	private static List list;

	public static void main(String[] args) {
		
		/**
		 * 2 创建一个Display对象，并使用这个display创建一个窗口(Shell),
		 * 	 并设置它的标题和窗口的初始尺寸。因为当前线程创建了Display对象，所以
		 * 	它(display)是界面线程
		 */
		Display display = Display.getDefault();
		final Shell shell = new Shell(display);
		shell.setText("Hello SWT");
		shell.setSize(260, 283);
		shell.open();

		/**
		 * 3 创建一个Text控件并设置其内容。然后设置控件的位置
		 * 坐上顶点为(10,8),宽度为230，高度为35
		 */
		text = new Text(shell, SWT.BORDER);
		text.setText("SWT是Eclipse平台使用的图形工具箱");
		text.setBounds(10, 8, 230, 35);

		/**
		 * 4 List控件可以显示一系列的内容，类似grid显示风格，
		 * 	 此处处创建了4行
		 */
		list = new List(shell, SWT.BORDER);
		list.setItems(new String[] { "使用操作系统本地控件", "提供一套平台无关的API", "GUI程序的运行速度快", "更多更多....." });
		list.setBounds(10, 68, 232, 82);

		/**
		 * 5 创建Label组件
		 */
		benefitOfSwtLabel = new Label(shell, SWT.NONE);
		benefitOfSwtLabel.setText("SWT的优点:");
		benefitOfSwtLabel.setBounds(10, 49, 90, 15);

		/**
		 * 6 Group对象可以将先关的空间宝成一组,
		 * 	 在这一组控件的会显示一个边框，可以看出不同
		 */
		group = new Group(shell, SWT.NONE);
		group.setText("你使用过哪些图形工具箱?");
		group.setBounds(10, 159, 230, 47);

		/**
		 * 7 Button类型和html元素类型相似
		 */
		awtButton = new Button(group, SWT.CHECK);
		awtButton.setText("AWT");
		awtButton.setBounds(10, 20, 54, 18);

		swingButton = new Button(group, SWT.CHECK);
		swingButton.setText("Swing");
		swingButton.setBounds(70, 22, 60, 15);

		swtButton = new Button(group, SWT.CHECK);
		swtButton.setBounds(136, 22, 62, 15);
		swtButton.setText("SWT");

		/**
		 * 此处创建了一个普通的按钮。按钮被按下时候，
		 * 	会触发选择事件(SelectionEvent)
		 */
		button = new Button(shell, SWT.NONE);
		button.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(final SelectionEvent e) {
				MessageBox msgBox = new MessageBox(shell, SWT.ICON_INFORMATION);
				msgBox.setMessage("Hello SWT!");
				msgBox.open();
			}
		});
		button.setText("按一下按钮,向SWT说Hello");
		button.setBounds(10, 214, 227, 25);

		shell.layout();

		while (!shell.isDisposed()) {
			if (!display.readAndDispatch())
				display.sleep();
		}
	}

}
