package com.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

public class GenerateInventoryDCXML {

	public static void main(String args[]) {

		FileInputStream fileInputStream;

		String[] storeList = new String[] {

				//DCs
			//	"LULU_CA_DEL_XBRD", "LULU_US_WC_ECOMM", "LULU_US_EC_ECOMM", 
			//	"LULU_CA_TOR_XBRD","LULU_CA_ECOMM","LULU_CA_TOR_ECOMM",
				//"LULU_CA_TOR_ECOMM",
				   "10934",
					"16310",
					"00311",
					"10636",
					"10218",
					"10915",
					"10916",
					"10919",
					"11320",
					"11223",
					"24005",
					"11330",
					"00517",
					"11851",
					"00161",
					"00260",
					"21021",
					"11603",
					"00513",
					"00515",
					"00518",
					"00506",
					"19020",
					"11954",
					"00510",
					"10217",
					"10917",
					"11331",
					"11852",
					"00120",
					"00160",
					"00170",
					"00220",
					"10231",
					"00512",
					"00110",
					"00212",
					"10513",
					"23013",
					"00171",
					"00261",
					"00230",
					"14018",
					"11512",
					"10814",
					"00432",
					"00610",
					"00710",
					"10211",
					"10212",
					"10219",
					"10224",
					"10227",
					"10226",
					"10229",
					"10230",
					"10322",
					"23018",
					"11807",
					"21015",
					"10168",
					"00267",
					"00351",
					"00430",
					"10210",
					"10214",
					"10228",
					"10236",
					"10238",
					"15303",
					"21017",
					"24004",
					"16011",
					"00172",
					"00262",
					"00264",
					"00268",
					"00273",
					"10234",
					"15201",
					"10639",
					"00240",
					"00272",
					"00275",
					"00274",
					"00331",
					"00288",
					"00321",
					"10515",
					"15302",
					"10283",
					"00141",
					"00250",
					"00332",
					"10512",
					"10615",
					"10591",
					"10618",
					"10600",
					"10616",
					"10424",
					"10628",
					"10621",
					"10624",
					"10282",
					"10629",
					"10722",
					"10727",
					"10718",
					"10730",
					"10634",
					"21019",
					"23019",
					"24003",
					"10510",
					"21012",
					"10176",
					"10650",
					"11602",
					"00121",
					"15202",
					"24002",
					"21011",
					"10617",
					"00131",
					"00340",
					"00345",
					"00350",
					"00354",
					"11905",
					"00358",
					"00129",
					"00214",
					"10670",
					"00177",
					"00341",
					"10419",
					"10584",
					"10588",
					"10652",
					"00217",
					"10613",
					"10728",
					"10648",
					"11001",
					"11009",
					"00179",
					"00190",
					"00269",
					"00282",
					"00296",
					"00297",
					"00298",
					"00342",
					"00507",
					"00760",
					"10297",
					"10434",
					"10646",
					"10754",
					"10755",
					"10756",
					"10757",
					"10758",
					"10726",
					"10909",
					"11222",
					"11333",
					"10933",
					"11101",
					"10317",
					"10324",
					"11513",
					"11804",
					"11901",
					"10851",
					"10928",
					"10929",
					"10935",
					"11201",
					"10313",
					"10502",
					"11651",
					"12011",
					"15013",
					"11906",
					"10812",
					"10633",
					"11952",
					"12015",
					"12016",
					"15014",
					"15016",
					"18013",
					"18015",
					"10932",
					"10251",
					"00270",
					"00271",
					"00290",
					"10511",
					"10610",
					"10612",
					"10622",
					"10711",
					"10715",
					"10724",
					"10319",
					"10811",
					"10240",
					"10744",
					"11335",
					"11422",
					"11423",
					"22014",
					"22016",
					"13022",
					"14011",
					"14015",
					"10731",
					"10320",
					"14016",
					"16002",
					"16101",
					"17011",
					"18010",
					"10820",
					"19022",
					"22010",
					"16201",
					"10643",
					"23015",
					"10151",
					"10171",
					"23012",
					"10192",
					"10743",
					"23014",
					"10127",
					"16300",
					"10619",
					"10815",
					"10710",
					"10116",
					"10197",
					"00291",
					"10700",
					"10134",
					"10318",
					"14013",
					"10266",
					"10253",
					"15203",
					"10163",
					"00175",
					"10822",
					"11950",
					"10592",
					"10745",
					"10729",
					"10284",
					"10172",
					"10627",
					"10429",
					"10623",
					"10135",
					"10412",
					"10422",
					"10150",
					"10160",
					"10632",
					"00181",
					"11850",
					"10263",
					"10641",
					"10821",
					"10423",
					"10175",
					"10651",
					"10190",
					"10169",
					"10640",
					"11907",
					"10816",
					"10196",
					"10428",
					"10125",
					"10645",
					"00142",
					"00213",
					"10824",
					"00187",
					"00600",
					"11700",
					"12013",
					"11904",
					"12014",
					"15400",
					"18012",
					"23016",
					"10810",
					"11424",
					"13014",
					"13020",
					"10913",
					"10924",
					"10927",
					"10931",
					"11100",
					"10311",
					"10312",
					"11511",
					"11803",
					"11903",
					"12010",
					"13016",
					"15012",
					"19010",
					"21010",
					"10323",
					"11420",
					"11421",
					"22011",
					"13021",
					"14012",
					"14014",
					"14017",
					"10181",
					"18014",
					"11704",
					"10625",
					"10590",
					"10581",
					"10593",
					"10126",
					"18011",
					"14019",
					"16010",
					"18005",
					"23011",
					"10825",
					"19021",
					"19024",
					"22501",
					"10213",
					"10110",
					"10189",
					"10185",
					"10259",
					"10118",
					"00720",
					"10170",
					"10813",
					"11011",
					"10130",
					"11031",
					"10120",
					"10725",
					"10817",
					"10818",
					"10922",
					"11220",
					"10930",
					"10950",
					"10310",
					"10314",
					"10503",
					"10303",
					"10583",
					"10716",
					"10770",
					"10771",
					"10769",
					"10415",
					"10772",
					"10773",
					"11002",
					"00721",
					"00218",
					"00359",
					"00252",
					"21029",
					"10658",
					"11004",
					"12061",
					"11910",
					"11912",
					"11917",
					"12019",
					"12020",
					"10309",
					"10654",
					"11913",
					"11008",
					"00754",
					"12052",
					"12054",
					"12060",
					"12062",
					"12065",
					"12068",
					"12074",
					"12082",
					"12084",
					"11308",
					"12085",
					"12086",
					"12087",
					"12088",
					"12089",
					"12092",
					"12093",
					"00145",
					"00292",
					"10195",
					"10759",
					"10760",
					"10761",
					"10762",
					"10763",
					"10764",
					"10765",
					"10766",
					"10767",
					"10801",
					"10828",
					"11140",
					"11303",
					"11304",
					"11305",
					"11306",
					"11309",
					"11314",
					"11317",
					"11318",
					"11319",
					"11336",
					"12023",
					"12024",
					"12025",
					"18021",
					"10296",
					"10644",
					"11412",
					"11915",
					"11920",
					"12050",
					"24000",
					"16001",
					"10167",
					"00519",
					"00755",
					"10748",
					"11923",
					"11909",
					"00162",
					"10307",
					"10418",
					"10638",
					"10582",
					"00293",
					"10182",
					"11010",
					"10136",
					"21014",
					"10165",
					"10122",
					"10265",
					"10594",
					"10410",
					"10420",
					"11809",
					"11808",
					"10199",
					"00185",
					"23017",
					"00215",
					"00216",
					"00279",
					"10304",
					"10305",
					"10416",
					"10518",
					"10585",
					"10586",
					"10587",
					"10626",
					"10637",
					"10642",
					"10647",
					"10306",
					"10655",
					"10657",
					"10659",
					"10750",
					"10752",
					"10753",
					"23021",
					"23022",
					"11003",
					"10519",
					"11911",
					"11916",
					"21020",
					"10774",
					"12017",
					"11006",
					"10580",
					"10137",
					"10421",
					"18002",
					"15015",
					"10180",
					"11908",
					"10262",
					"10649",
					"10162",
					"12071",
					"11925",
					"11927",
					"10308",
					"00752",
					"11310",
					"12028",
					"12031",
					"12032",
					"12034",
					"12049",
					"12051",
					"12057",
					"12063",
					"12066",
					"12067",
					"12070",
					"12072",
					"12073",
					"12075",
					"12076",
					"12077",
					"12078",
					"12079",
					"12080",
					"12081"
				//"10080", "10010"
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

		Document inventoryDocument;
		Element inventoryElment;
		Element items = null;
		HSSFWorkbook workbook;
		HSSFSheet worksheet;
		Iterator rows = null;

		HSSFRow row;
		int i;

		String sItemID;
		String sQty;
		Element item;
		Element supplies;
		Element supply;

		for (String sShipNode : storeList) {

			ArrayList<String> itemList = new ArrayList<String>();

			String sNumber = "_20190821200";
			try {
//				D:\SyncExcels
				//input xls file pathC:\Users\Rajat Anikhindi\Downloads\InventorySync\Java Code\backup12112019\DCxls
				fileInputStream = new FileInputStream("D:\\SyncExcels\\Store_5k_Night.xls");
				//fileInputStream = new FileInputStream("C://Users//Rajat Anikhindi//Downloads//InventorySync//Java Code//backup12112019//STORExls//Store_"+sShipNode+".xls");
				workbook = new HSSFWorkbook(fileInputStream);
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
           int count=0;
           
			while (rows.hasNext()  ) {
				row = (HSSFRow) rows.next();
				count++;
				System.out.println("count "+count);
				sItemID = new DataFormatter().formatCellValue(row.getCell(0)).trim();
				sQty = new DataFormatter().formatCellValue(row.getCell(1)).trim();
				if(sItemID.equals("ITEM_ID")&&sQty.equals("QUANTITY")) {
					continue;
				}else {
					map.put(sItemID, sQty);

					itemList.add(sItemID);
				}	
			}

			//keeping 80% quantity same as read from xls 
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
			Collections.shuffle(itemList);

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
							//quantity for 20% items
							//supply.setAttribute("Quantity", "7500");
							supply.setAttribute("Quantity", map.get(sItemID));
						}
					}

					if (i == itemSize || (counter ==  itemList.size() -1)) {

						System.out.println("Here after loop : "+ i + " "+ itemList.size() + " "+ counter);

						//output DC XML file pathD://Lulu
						//File currentFile = new File("D://Lulu//" + sShipNode + sNumber + j + "00_fullsync.xml");
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
