class improved_summary_Servlet{
	
	SummaryTool summary;
	public improved_summary_Servlet(){
		summary = new SummaryTool();
		summary.init();
	}
	
	public void loadFullText(String arg){
		summary.extractSentenceFromContext(arg);
		doSummerization();
	}
	
	private void doSummerization(){
		summary.groupSentencesIntoParagraphs();
		summary.createIntersectionMatrix();
		summary.createDictionary();
		summary.createSummary();
	}
	
	public void consolePrint(){//modified
		summary.printSentences();
		System.out.println("SUMMMARY");
		summary.printSummary();
		summary.printStats();
	}
	
	public String responseCreation(){
		return "<div class=\"Statistics\">"+summary.getStats()+"</div><div class=\"Summary\">"+summary.getSummary()+"</div>";
	}
}