package net.dfrz.log;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import net.dfrz.resource.Resource;
import net.dfrz.tools.Tools;
import net.dfrz.view.MainMenu;

public class Log {
	public static void addLog(String message) {

		String now = Tools.getDateYMDHM();
		File file = new File(Resource.LogPath + "log" + Tools.getDateYMD()
				+ ".txt");
		StringBuffer sb = null;
		BufferedWriter bw = null;

		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		try {
			sb = new StringBuffer();
			sb.append(now + "---" + MainMenu.onlineUser.getLogName() + "---"
					+ message);
			bw = new BufferedWriter(new FileWriter(file, true));
			bw.write(sb.toString());
			bw.newLine();
			bw.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
