package baseUse;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReadSQLXml {
	private String host;
	private String	username;
	private String password;
	public void getInfo(){
		//（1）得到DOM解析器的工厂实例
        DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();
        //得到javax.xml.parsers.DocumentBuilderFactory;类的实例就是我们要的解析器工厂
        try {
            //（2）从DOM工厂获得DOM解析器
            DocumentBuilder dombuilder=domfac.newDocumentBuilder();
            //通过javax.xml.parsers.DocumentBuilderFactory实例的静态方法newDocumentBuilder()得到DOM解析器
            //（3）把要解析的XML文档转化为输入流，以便DOM解析器解析它
            System.out.println(new File(".").getAbsolutePath());
            InputStream is=new FileInputStream("sql.xml");            
            //（4）解析XML文档的输入流，得到一个Document
            Document doc=dombuilder.parse(is);
            //由XML文档的输入流得到一个org.w3c.dom.Document对象，以后的处理都是对Document对象进行的
            //（5）得到XML文档的根节点
            Element root=doc.getDocumentElement();
            //在DOM中只有根节点是一个org.w3c.dom.Element对象。
            //（6）得到节点的子节点
            NodeList sql=root.getChildNodes();
            
            if(sql != null){
            	for(int i = 0; i < sql.getLength(); i++){
	            	Node node = sql.item(i);
	            	if(node.getNodeType()==Node.ELEMENT_NODE){
	            		if(node.getNodeName().equals("host")){
	            			host=node.getFirstChild().getNodeValue();
	                    }
	                    else if(node.getNodeName().equals("username")){
	                        username=node.getFirstChild().getNodeValue();
	                    }
	                    else if(node.getNodeName().equals("password")){
	                        password=node.getFirstChild().getNodeValue();
	                    }     
	            	}
            	}
            }
            
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }		
	}
	
	public String getHost(){
		return host;
	}
	public String getUsername(){
		return username;
	}
	public String getPassword(){
		return password;
	}
	
	public static void main(String args[]){
		ReadSQLXml r = new ReadSQLXml();
		r.getInfo();
		
		System.out.println(r.getHost() + " " + r.getUsername() + " " + r.getPassword());
	}

}
