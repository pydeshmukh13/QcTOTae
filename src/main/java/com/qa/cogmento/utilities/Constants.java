package com.qa.cogmento.utilities;

import java.util.ArrayList;
import java.util.List;

public class Constants {
	
	public static final String Login_Page_Title="Cogmento CRM";
	public static final String Home_Page_Title="Cogmento CRM";
	public static final String Expected_Error_Message="Something went wrong...";
	
	public static final int HomePage_Sections=6;
	public static final String Contact_Page_Header="Contacts";
	
	public static final String Contact_Sheet_Name="Contacts";
	public static final String Comapny_Page_Header="Companies";
	
	public static final int buttonsCount=3;
	
	public static List<String> getHomePageSectionsList() {
		
		List<String> sectionList=new ArrayList<String>();
		sectionList.add("Deals Summary");
		sectionList.add("Sale Targets");
		sectionList.add("Contacts activity stream");
		sectionList.add("Deals");
		sectionList.add("Twitter");
		sectionList.add("Exchange Rates");
		
		return sectionList;
	}
	
	public static List<String> getButtonsList(){
		
		List<String> buttonsList=new ArrayList<String>();
		buttonsList.add("Show Filters");
		buttonsList.add("Export");
		buttonsList.add("Create");
				
		return buttonsList;
	}
	
public static List<String> getColumnNameList(){
		
		List<String> ColumnNameList=new ArrayList<String>();
		ColumnNameList.add("Name");
		ColumnNameList.add("Address");
		ColumnNameList.add("Category");
		ColumnNameList.add("Status");
		ColumnNameList.add("Phone");
		ColumnNameList.add("Email");
		ColumnNameList.add("Options");
		
		return ColumnNameList;
	}

}
