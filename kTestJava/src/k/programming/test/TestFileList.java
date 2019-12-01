package k.programming.test;

import java.io.File;

class TestFileList {
	public static void main(String args[]) {
		File file = null;
		if (args.length == 0) {
			file = new File(".");
		} else {
			file = new File(args[0]);
		}
		TestFileList fileList = new TestFileList();
		fileList.recurse(file, 0);
	}

	void recurse(File dirFile, int depth) {
		String contents[] = dirFile.list();
		for (int i = 0; i < contents.length; i++) {
			for (int spaces = 0; spaces < depth; spaces++)
			System.out.print("    ");
			System.out.println(contents[i]);
			File child = new File(dirFile, contents[i]);
			if (child.isDirectory())
				recurse(child, depth + 1);
		}
	}
}

