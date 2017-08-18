package com.mst;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by wanglu-jf on 17/8/18.
 */
public class GetListByFileName {

    /**
     * 根据传入的文件名，解析文件中声明的类（每行一个类名），并将有效的类名以集合的方式返回。
     * @param fileName
     * @return
     */
    public List getClass(String fileName){
        File classFile = new File(fileName);
        List classNames = new ArrayList();
        try {
            FileReader fileReader = new FileReader(classFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String readContent = null;
            try {
                while((readContent = bufferedReader.readLine())!=null){
                    classNames.add(readContent);
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return classNames;
    }

    /**
     * 修改后
     */
    public List getClassByFileName(String fileName){
        File classFile = new File(fileName);
        List classNames = new ArrayList();
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
            fileReader = new FileReader(classFile);
            bufferedReader = new BufferedReader(fileReader);
            String readContent = null;
            while((readContent = bufferedReader.readLine())!=null){
                classNames.add(readContent);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException ioe){
            ioe.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return classNames;
    }
}
