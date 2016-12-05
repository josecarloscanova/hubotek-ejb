package org.hubotek.service.google.search;

public enum LanguageEnum {

	Arabic("ar"),
	Bulgarian("bg"),
	Catalan("ca"),
	Croatian("hr"),
	Chinese("zh-Hans"),
	Chinese_T("zh-Hant"),
	Czech("cs"),
	Danish("da"),
	Dutch("nl"),
	English("en"),
	Filipino("fil"),
	Finnish("fi"),
	French("fr"),
	German("de"),
	Greek("el"),
	Hebrew("he"),
	Hindi("hi"),
	Hungarian("hu"),
	Indonesian("id"),
	Italian("it"),
	Japanese("ja"),
	Korean("ko"),
	Latvian("lv"),
	Lithuanian("lt"),
	Norwegian("no"),
	Polish("pl"),
	Portuguese("pt"),
	Romanian("ro"),
	Russian("ru"),
	Serbian("sr"),
	Slovak("sk"),
	Slovenian("sl"),
	Spanish("es"),
	Swedish("sv"),
	Thai("th"),
	Turkish("tr"),
	Ukrainian("uk"),
	Vietnamese("vi");
	
	private String countryValue;

	private LanguageEnum(String countryValue)
	{ 
		this.countryValue = countryValue;
	}
	
	public String getCountryValue() {
		return countryValue;
	} 
	
}
