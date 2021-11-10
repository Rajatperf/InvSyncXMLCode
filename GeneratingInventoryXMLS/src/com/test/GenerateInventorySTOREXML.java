package com.test;

import java.awt.event.ItemListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
//import org.apache.poi.xssf.usermodel.XSSFWorkbookFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

//import com.oracle.xmlns.internal.webservices.jaxws_databinding.ExistingAnnotationsType;
//import com.sun.javafx.binding.StringFormatter;
import com.test.XMLUtil;

import edu.emory.mathcs.backport.java.util.Collections;

public class GenerateInventorySTOREXML {

	public static void main(String args[]) {

		FileInputStream fileInputStream;
		Random random = new Random();
		GenerateInventoryDCXML obj = new GenerateInventoryDCXML();


		String[] storeList = new String[] { 
							
				//new 405 stores
				"00190", "10170", "00275", "10851", "00340", "10415", "10583", "10312", "10725",
				"15014", "10322", "10646", "10150", "10913", "00214", "00342", "11330", "10610",
				"10512", "10511", "00260", "19021", "23012", "00290", "10419", "10764", "11808",
				"10930", "10762", "10627", "10731", "18010", "10928", "10226", "11423", "11305",
				"12011", "10759", "10619", "15013", "18021", "10323", "10306", "00131", "00272",
				"00274", "00179", "00345", "10190", "10810", "00252", "19022", "10310", "10621",
				"00120", "00261", "00264", "10718", "10924", "10649", "10428", "23022", "00141",
				"24004", "13014", "10758", "10320", "10625", "10429", "14015", "21021", "23011",
				"11954", "10724", "10180", "10519", "10192", "10231", "22014", "11700", "16010",
				"11651", "12016", "10767", "10136", "10640", "10633", "10584", "10318", "10172",
				"11803", "11001", "13016", "10756", "10716", "00171", "00282", "12017", "12024",
				"00240", "21012", "10116", "10319", "10515", "10423", "10715", "00230", "10624",
				"10648", "11424", "00177", "00430", "10181", "10227", "24003", "10120", "11101",
				"11335", "10218", "10422", "00269", "10642", "11904", "10134", "10137", "10628",
				"11809", "10151", "10518", "10195", "00212", "10110", "10317", "10765", "10126",
				"10165", "11422", "10760", "10730", "15012", "11008", "10163", "11852", "10176",
				"13020", "11952", "10763", "21010", "10314", "10659", "11006", "00270", "10629",
				"11304", "23015", "10421", "10224", "10651", "10650", "10212", "10755", "10313",
				"00215", "15303", "10744", "13021", "00515", "10199", "11222", "11009", "10750",
				"14011", "10617", "18012", "00351", "11602", "10931", "11909", "16011", "10774",
				"11901", "00358", "10210", "10214", "10670", "10769", "10726", "16101", "11317",
				"10927", "10305", "00710", "11004", "10612", "10711", "10748", "10641", "14013",
				"10588", "11421", "11907", "10592", "00512", "11309", "00507", "15302", "10727",
				"12015", "12010", "00517", "11807",	"00170", "21011", "00720", "10185", "10657",
				"11220", "00161", "10643", "23013", "11320", "10238", "10636", "11704", "10770",
				"10590", "21020", "18014", "10634", "11511", "10615", "14018", "10622", "10503",
				"11905", "15016", "00721", "00279", "11333", "10632", "10637", "18011", "10752",
				"10303", "00518", "14012", "10771", "10167", "18005", "10618", "00288", "11003",
				"14014", "10626", "00359", "10420", "12025", "11306", "00760", "00160", "00331",
				"10229", "19020", "10416", "10217", "00110", "00273", "10130", "10934", "23021",
				"00311", "18013", "00513", "00510", "10950", "00432", "10162", "10753", "10135",
				"10593", "10929", "10196", "16001", "10580", "10230", "10160", "10234", "10127",
				"10424", "16201", "21015", "21019", "16310", "10586", "22010", "11223", "00271",
				"10510", "00216", "10412", "22016", "00121", "10638", "10722", "11002", "24002",
				"10772", "12013", "21017", "10182", "12061", "21014", "10743", "10761", "19010",
				"00298", "00250", "00187", "00220", "10513", "10175", "10168", "11318", "00268",
				"00519", "12014", "00218", "00217", "10935", "10645", "11804", "00262", "10623",
				"10658", "10434", "11336", "10828", "10219", "00341", "00350", "24005", "10916",
				"10251", "10410", "13022", "14016", "00332", "11011", "22011", "10311", "10585",
				"10710", "10213", "11331", "10773", "10655", "10211", "19024", "10639", "10594",
				"10297", "11140", "00296", "11319", "10197", "00600", "10754", "11911", "00172",
				"10933", "00610", "00213", "10122", "00129", "11010", "23014", "10613", "10922",
				"10591", "00321", "10171", "10745", "23017", "10581", "10652", "10304", "22501",
				"00267", "10228", "21029", "15202", "11908", "10502", "15203", "10766", "10757",
				"10917", "10932", "10801", "11201", "10647", "10915", "11916", "11308", "00297",
				"00297","11308"
				
		};


		String[] saIgnoredStoreList = new String[] { 
				"40056","40056","40056","40056","40056",
				"40056","40056","40056","40056","40056",
				"66056","66056","66056","66056","66056",
				"66056","50156","50156","50156","50156"
		};

		Set<String> hsIgnoredStoreList = new HashSet<>(Arrays.asList(saIgnoredStoreList));


		String[] saIgnoredItems = new String[] { 
				"21281","21282","21283","21284",
				"21279","21280","21281","21282",
				"21283","21284","21281","21282" };

		Set<String> hsIgnoredItems = new HashSet<>(Arrays.asList(saIgnoredItems));
		//boolean bEverWrittenToFile = false;
		Document inventoryDocument;
		Element inventoryElment;
		Element items = null;
		XSSFWorkbook workbook;
		XSSFSheet worksheet;
		XSSFSheet worksheet1;
		Iterator rows = null;
		
		XSSFRow row;
		XSSFRow row1;
		int i;
		XSSFCell ItemId; 

		String sItemID;
		String sQty;
		Element item;
		Element supplies;
		Element supply;

		for (String sShipNode : storeList) {
			
			ArrayList<String> itemList = new ArrayList<String>();
			ArrayList<String> qtyList = new ArrayList<String>();
			
		String sNumber = "_20190821200";
		try {
			//fileInputStream = new FileInputStream("C:\\Users\\Rajat Anikhindi\\Downloads\\InventorySync\\Java Code\\backup12112019\\DCxls\\"+"LULU_CA_DEL_XBRD"+".xls");
		fileInputStream = new FileInputStream("C://Users//Rajat Anikhindi//Downloads//InventorySync//Java Code//backup12112019//STORExls//Store_"+sShipNode+".xls");
			String stringFileInputStream ="C://Users//Rajat Anikhindi//Downloads//InventorySync//Java Code//backup12112019//STORExls//Store_"+sShipNode+".xls";
			workbook = new XSSFWorkbook(stringFileInputStream);
			worksheet = workbook.getSheetAt(0);
			rows = worksheet.rowIterator();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Map<String,String> map = new HashMap<String,String>();

		while (rows.hasNext()) {
			row = (XSSFRow) rows.next();
		
			sItemID = new DataFormatter().formatCellValue(row.getCell(0)).trim();
			sQty = new DataFormatter().formatCellValue(row.getCell(1)).trim();
			if(sItemID.equals("ITEM_ID")&&sQty.equals("QUANTITY")) {
				continue;
			}else {
				map.put(sItemID, sQty);
				
				itemList.add(sItemID);
			}	
		}
		
		int itemCount = (int) (0.8*itemList.size());
		List<Integer> listOfIntegers = itemList.parallelStream().map(s->Integer.parseInt(s)).collect(Collectors.toList());
		java.util.Collections.sort(listOfIntegers);
		itemList = (ArrayList<String>) listOfIntegers.parallelStream().map(s->String.valueOf(s)).collect(Collectors.toList());
		System.out.println(itemCount+" "+sShipNode);
		
		int j = 0;

			//Avoiding resetting the Inventory for QA Stores
			if(hsIgnoredStoreList.contains(sShipNode.trim())){
				continue;
			}

			try {
				DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
				DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
				inventoryDocument = dBuilder.newDocument();

				inventoryElment = inventoryDocument.createElement("oms:Inventory");
				inventoryDocument.appendChild(inventoryElment);

				inventoryElment.setAttribute("ShipNode", sShipNode);
				inventoryElment.setAttribute("CompleteInventoryFlag", "Y");
				inventoryElment.setAttribute("ValidateItems", "N");
				inventoryElment.setAttribute("ApplyDifferences", "Y");
				inventoryElment.setAttribute("ReasonCode", "FULL_SYNC" + sNumber + "00");
				inventoryElment.setAttribute("xmlns:oms", "http://www.lululemon.com/InvFullSync");
				inventoryElment.setAttribute("xsi:schemaLocation",
						"http://www.lululemon.com/InvFullSync OMSInvSync.xsd");
				inventoryElment.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
				items = XMLUtil.createChild(inventoryElment, "oms:Items");

				i = 1;

				for (int counter = 0; counter <= itemList.size()-1; counter++) {  

					sItemID = itemList.get(counter);

					//Avoiding resetting the Inventory for QA Items
//					if(hsIgnoredItems.contains(sItemID.trim())){
//						//i = i+1;
//						continue;
//					}
					
					int itemSize = itemList.size();

					if (i <= itemSize) {
						item = XMLUtil.createChild(items, "oms:Item");
						item.setAttribute("ItemID", sItemID.trim());
						item.setAttribute("InventoryOrganizationCode", "LULU_ECOMM");
						item.setAttribute("UnitOfMeasure", "EACH");
						supplies = XMLUtil.createChild(item, "oms:Supplies");
						supply = XMLUtil.createChild(supplies, "oms:Supply");
						supply.setAttribute("AvailabilityType", "TRACK");
						supply.setAttribute("SupplyType", "ONHAND");
						if(i <= itemCount) {
							supply.setAttribute("Quantity", map.get(sItemID));
						}else {
							supply.setAttribute("Quantity", "10000");
						}
					}

					if (i == itemSize || (counter ==  itemList.size() -1)) {
						
						System.out.println("Here after loop : "+ i + " "+ itemList.size() + " "+ counter);

						File currentFile = new File("D://Lulu//Store//" + sShipNode + sNumber + j + "00_fullsync.xml");
						writeToFile(inventoryDocument, currentFile);
						Element a = inventoryDocument.getDocumentElement();
						XMLUtil.removeChild(a, items);


						i=0;
						j = j + 1;

						inventoryElment.setAttribute("ShipNode", sShipNode);
						inventoryElment.setAttribute("CompleteInventoryFlag", "Y");
						inventoryElment.setAttribute("ValidateItems", "N");
						inventoryElment.setAttribute("ApplyDifferences", "Y");
						inventoryElment.setAttribute("ReasonCode", "FULL_SYNC" + sNumber + "00");
						inventoryElment.setAttribute("xmlns:oms", "http://www.lululemon.com/InvFullSync");
						inventoryElment.setAttribute("xsi:schemaLocation",
								"http://www.lululemon.com/InvFullSync OMSInvSync.xsd");
						inventoryElment.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
						items = XMLUtil.createChild(inventoryElment, "oms:Items");



						//inventoryDocument = dBuilder.newDocument();



						/*
						 * NodeList a=inventoryDocument.getElementsByTagName("oms:Supplies"); for (int k
						 * = 0; k < a.getLength(); k++) {
						 * inventoryDocument.getDocumentElement().removeChild(a.item(k)); }
						 */

					}

					i = i + 1;
				}



			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ParserConfigurationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getCellValue(XSSFCell cell) {
		String sValue = "";

		if (null != cell) {
			if (cell.getColumnIndex() == 0) {

				sValue = String.valueOf(cell.getNumericCellValue());
				sValue = sValue.replace(".0", "");
				sValue = sValue.replace(".00", "");

			} else {
				sValue = cell.getStringCellValue();
			}
		}
		return sValue;
	}

	private static void writeToFile(Node node, File file) throws Exception {
		Transformer transformer = TransformerFactory.newInstance().newTransformer();

		transformer.transform(new DOMSource(node), new StreamResult(new FileWriter(file)));
	}	


}
