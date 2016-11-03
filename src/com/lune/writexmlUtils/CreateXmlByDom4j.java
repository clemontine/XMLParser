package com.lune.writexmlUtils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

import com.lune.readxmlUtils.ReadXMLByDom4j;

/**
 * 
 * @author lune
 */
public class CreateXmlByDom4j {
	
	
	
	private void createXML(String fileName){
		//1.创建Document对象,代表整个Xml文档
		Document document = DocumentHelper.createDocument();
		//2.创建根节点
		Element rss = document.addElement("rss");
		//3.添加rss的version属性
		rss.addAttribute("version", "2.0");
		//4.生成子节点及节点内容
		Element channel = rss.addElement("channel");
		Element title = channel.addElement("title");
		title.setText("百度国内焦点新闻");
		Element image = rss.addElement("image");
		
		Element title1 = image.addElement("title");
		Element link = image.addElement("link");
		Element url = image.addElement("url");
		
		title1.setText("news.baidu.com");
		link.setText("http://news.baidu.com");
		url.setText("http://img.baidu.com/img/logo-news.gif");
		
		
		//5.生成xml文件
		XMLWriter writer;
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();  //设置xml格式,带换行缩进
			format.setEncoding("gbk");
			writer = new XMLWriter(new FileOutputStream(new File(fileName)) , format);
			writer.setEscapeText(false);        //设置是否转义，默认true为转义
			writer.write(document);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String fileName = "src/res/rrsnews.xml";
		new CreateXmlByDom4j().createXML(fileName);
	}

}
