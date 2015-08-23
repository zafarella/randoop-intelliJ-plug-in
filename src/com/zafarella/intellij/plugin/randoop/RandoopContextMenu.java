package com.zafarella.intellij.plugin.randoop;

import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.actionSystem.DataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.vfs.VirtualFile;

/**
 * Created by z1 on 8/23/15.
 */
public class RandoopContextMenu extends AnAction {
	@Override
	public void actionPerformed(AnActionEvent anActionEvent) {

		final Project project = anActionEvent.getData(CommonDataKeys.PROJECT);
		final Editor editor = anActionEvent.getData(CommonDataKeys.EDITOR);
		// todo: add launching randoop
		// see usage at https://rawgit.com/mernst/randoop/master/doc/index.html#running_randoop
		// Here we need to determine the file type we are dealing.
		//		then we need to make the menu item either visible or not

		// current dir of the file
		// VirtualFile folder = file.getParent();
	}


	@Override
	public void update(final AnActionEvent e) {
		//Get required data keys
		final Project project = e.getData(CommonDataKeys.PROJECT);
		final Editor theEditor = e.getData(CommonDataKeys.EDITOR);
		VirtualFile file = DataKeys.VIRTUAL_FILE.getData(e.getDataContext());
		//		set it visible if it is java file
		e.getPresentation().setVisible(file.getFileType().getName().toLowerCase().equals("java") &&
						(project != null && theEditor != null)
		);
	}
}
