package Common_methods;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import javax.xml.transform.TransformerFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.TestNG;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;



public class CreateTestNgXML {
	
	public static void createXml() throws Exception{
		try{
			DocumentBuilderFactory documentBuilderFactory =  DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument(); 
			
			String xFilePath = null;
			xFilePath = "C:\\Automation\\AutoDEVLab_L\\Data\\data.xls";
			
			ExcelSheetLibrary lib = new ExcelSheetLibrary(xFilePath);
			lib.GetFlaggedMethods("ExecutionReady");
			
			int totalTestCases = lib.flaggedMethod.size();
			
			Element rooElementsuite = document.createElement("suite");
			Element rootElementtest = document.createElement("test");
			Element rootElementClass = document.createElement("classes");
			
			rooElementsuite.appendChild(rootElementtest);
			rootElementtest.appendChild(rootElementClass);
			rooElementsuite.setAttribute("name", "BVT Dev");
//			rooElementsuite.setAttribute("parallel", "methods");
//			rooElementsuite.setAttribute("thread-count", "2");
			
			rootElementtest.setAttribute("name", "BVT");
			document.appendChild(rooElementsuite);
			String PreviousClassName = null;
			 for(int ec = 1; ec <= totalTestCases;ec++){
				 String[] flagElement = lib.flaggedMethod.get(ec).toString().split(";");
				 
				 if(flagElement[1].equalsIgnoreCase(PreviousClassName)==false){
					 Element childelementClass = document.createElement("class");
					 childelementClass.setAttribute("name", flagElement[1]);
					 rootElementClass.appendChild(childelementClass);
					 PreviousClassName = flagElement[1];
					 Element rootElementgroups = document.createElement("methods");
					 childelementClass.appendChild(rootElementgroups);
					 for(int ec1 = 1; ec1 <= totalTestCases; ec1++){
						 String[] flagElement1 = lib.flaggedMethod.get(ec1).toString().split(";");
						 
						 if(flagElement[1].contentEquals(flagElement1[1])== true){
							 String element = "include";
							 Element em = document.createElement(element);
							 em.setAttribute("name", flagElement1[0]);
							 rootElementgroups.appendChild(em);
							 
						 }
					 }
				 }
			 }
			
			 FileWriter fstream = new FileWriter("testng.xml");
			 BufferedWriter out = new BufferedWriter(fstream);
			 TransformerFactory transformerFactory = TransformerFactory.newInstance();
			 Transformer transformer  = transformerFactory.newTransformer();
			 DOMSource source = new DOMSource(document);
			 
			 StreamResult result = new StreamResult(fstream);
			 transformer.transform(source,result);
			 System.out.println("Testng file created");
			 
			 out.close();
			 
		}catch(DOMException e){  
			e.printStackTrace();
		}
	}
	
	public static void autoRunXml(){
		
		List files =  new ArrayList();
		files.add("testng.xml");
		TestNG tng = new TestNG();
		tng.setTestSuites(files);
		tng.run();
		
	}

}


