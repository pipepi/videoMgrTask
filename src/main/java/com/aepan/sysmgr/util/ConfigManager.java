package com.aepan.sysmgr.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Properties;

public class ConfigManager {
	private static ConfigManager conf;
	private String taskHost;
	private ConfigManager(){
	}
	public static ConfigManager getInstants(){
		if(conf==null){
			conf = new ConfigManager();
		}
		return conf;
	}
	public String getTaskHost(){
		if(taskHost==null||taskHost.isEmpty()){
			taskHost = readProperties();
		}
		return taskHost;
	} 
	private static String readProperties(){
		String rs = "";
		String path = ConfigManager.class.getClassLoader().getResource("task.properties").getPath();
		FileInputStream fis;
		try {
			fis = new FileInputStream(new File(path));
			Properties prop = new Properties();
			prop.load(fis);
			if(prop.containsKey("taskhost")){
				rs = prop.getProperty("taskhost");
			}
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return rs;
	}
	public static void main(String[] args) throws URISyntaxException {
		/*File file = new File(".");
		System.out.println(file.getPath());
		System.out.println(file.getAbsolutePath());
		System.out.println(ConfigManager.class.getClassLoader().getResource("").toURI().getPath());
		System.out.println(readConfigFile());*/
		readProperties();
	}
	/*private static String readConfigFile(){
		String rs = "";
		String configFileDir = ConfigManager.class.getClassLoader().getResource("task.properties").getPath();
		File file = new File(configFileDir);
		if(file.exists()&&file.isFile()&&file.canRead()){
			try {
				FileInputStream fis = new FileInputStream(file);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				List<String> lines = new ArrayList<String>();
				String line = null;
				while((line=br.readLine())!=null){
					lines.add(line);
					break;//to do 暂时只读取第一行，后续可扩展 
				}
				if(lines.size()>0){
					String host = lines.get(0);
					if(host.indexOf("=")>-1){
						String[] ps = host.split("=");
						if(ps.length>1){
							rs = ps[1];
						}
					}
				}
				br.close();
				fis.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
			}
		}
		return rs;
	}*/
}
