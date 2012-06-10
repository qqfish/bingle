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
		//��1���õ�DOM�������Ĺ���ʵ��
        DocumentBuilderFactory domfac=DocumentBuilderFactory.newInstance();
        //�õ�javax.xml.parsers.DocumentBuilderFactory;���ʵ����������Ҫ�Ľ���������
        try {
            //��2����DOM�������DOM������
            DocumentBuilder dombuilder=domfac.newDocumentBuilder();
            //ͨ��javax.xml.parsers.DocumentBuilderFactoryʵ���ľ�̬����newDocumentBuilder()�õ�DOM������
            //��3����Ҫ������XML�ĵ�ת��Ϊ���������Ա�DOM������������
            System.out.println(new File(".").getAbsolutePath());
            InputStream is=new FileInputStream("sql.xml");            
            //��4������XML�ĵ������������õ�һ��Document
            Document doc=dombuilder.parse(is);
            //��XML�ĵ����������õ�һ��org.w3c.dom.Document�����Ժ�Ĵ����Ƕ�Document������е�
            //��5���õ�XML�ĵ��ĸ��ڵ�
            Element root=doc.getDocumentElement();
            //��DOM��ֻ�и��ڵ���һ��org.w3c.dom.Element����
            //��6���õ��ڵ���ӽڵ�
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
