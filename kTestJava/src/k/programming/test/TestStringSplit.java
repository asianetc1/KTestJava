package k.programming.test;

public class TestStringSplit {

	public static void main(String[] args) {

		String str=""+
"COM_CD11"+"\n"+
"COM_CD%VARCHAR2(8)%%PK%No%%"+"\n"+
"STYLE_CD%VARCHAR2(20)%%PK%No%%"+"\n"+
"STYLE_NM%VARCHAR2(60)%%%Yes%%"+"\n"+
"SZ_GBN_CD%VARCHAR2(8)%%%Yes%%"+"\n"+
"BRAND_CD%VARCHAR2(8)%%%Yes%%"+"\n"+
"MOD_DATE%DATE%%%No%%"+"\n"+
"MIP_TYPE_CD%CHAR(1)%%%No%'0' %"+"\n"+
"";

		String[] lines;
		String[] words;

		lines = str.split("\n");
		for(int i = 0; i < lines.length; i++) {
			System.out.println(i + ":" + lines[i]);
			words=lines[i].split("%");
			for (int j = 0; j < words.length; j++) {
				System.out.println("   "+j+":"+words[j]);	//test+++
			}
		}
	}

}
