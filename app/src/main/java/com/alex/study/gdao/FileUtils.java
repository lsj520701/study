package com.alex.study.gdao;

import java.io.File;
import java.io.IOException;

public class FileUtils {
    public static File buildDataBasePath(String dir, String name) {
    boolean sdExist = android.os.Environment.MEDIA_MOUNTED.equals(android.os.Environment.getExternalStorageState());
        if (!sdExist) {
        return null;
    } else {
        String dbDir = android.os.Environment.getExternalStorageDirectory().getAbsolutePath();
        String dbPath = dbDir + "/" + dir;// 数据库路径
        File dirFile = new File(dbPath);
        if (!dirFile.exists())
            dirFile.mkdirs();

        boolean isFileCreateSuccess = false;
        // 判断文件是否存在，不存在则创建该文件
        String filePath = dbPath + "/" + name;
        File dbFile = new File(filePath);
        if (!dbFile.exists()) {
            try {
                isFileCreateSuccess = dbFile.createNewFile();// 创建文件
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            isFileCreateSuccess = true;
        }
        if (isFileCreateSuccess)
            return dbFile;
        else
            return null;
    }
}

}
