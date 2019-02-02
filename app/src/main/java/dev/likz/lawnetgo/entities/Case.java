package dev.likz.lawnetgo.entities;

import java.util.List;

public class Case {
  private int id;
  private String title;
  private String caseNumber;
  private String decisionDate;
  private String tribunalCourt;
  private String coram;
  private String counselNames;
  private String parties;
  private CaseContent content1;
  private CaseContent content2;
  private CaseContent content3;
  private CaseContent content4;
  private CaseContent content5;
  private CaseContent content6;
  private CaseContent content7;
  private CaseContent content8;
  private CaseContent content9;
  private CaseContent content10;
  private String snippets;
  private int following;
  private int referring;
  private int favourite;

  public Case() {
  }

  public Case(String title, String caseNumber, String decisionDate, String tribunalCourt, String coram, String counselNames, String parties, CaseContent content1, CaseContent content2, CaseContent content3, CaseContent content4, CaseContent content5, CaseContent content6, CaseContent content7, CaseContent content8, CaseContent content9, CaseContent content10, String snippets, int following, int referring, int favourite) {
    this.title = title;
    this.caseNumber = caseNumber;
    this.decisionDate = decisionDate;
    this.tribunalCourt = tribunalCourt;
    this.coram = coram;
    this.counselNames = counselNames;
    this.parties = parties;
    this.content1 = content1;
    this.content2 = content2;
    this.content3 = content3;
    this.content4 = content4;
    this.content5 = content5;
    this.content6 = content6;
    this.content7 = content7;
    this.content8 = content8;
    this.content9 = content9;
    this.content10 = content10;
    this.snippets = snippets;
    this.following = following;
    this.referring = referring;
    this.favourite = favourite;
  }

  public Case(int id, String title, String caseNumber, String decisionDate, String tribunalCourt, String coram, String counselNames, String parties, CaseContent content1, CaseContent content2, CaseContent content3, CaseContent content4, CaseContent content5, CaseContent content6, CaseContent content7, CaseContent content8, CaseContent content9, CaseContent content10, String snippets, int following, int referring, int favourite) {
    this.id = id;
    this.title = title;
    this.caseNumber = caseNumber;
    this.decisionDate = decisionDate;
    this.tribunalCourt = tribunalCourt;
    this.coram = coram;
    this.counselNames = counselNames;
    this.parties = parties;
    this.content1 = content1;
    this.content2 = content2;
    this.content3 = content3;
    this.content4 = content4;
    this.content5 = content5;
    this.content6 = content6;
    this.content7 = content7;
    this.content8 = content8;
    this.content9 = content9;
    this.content10 = content10;
    this.snippets = snippets;
    this.following = following;
    this.referring = referring;
    this.favourite = favourite;
  }

  public Case(int id, String title, String caseNumber, String decisionDate, String tribunalCourt, String coram, String counselNames, String parties, CaseContent content1, CaseContent content2, CaseContent content3, CaseContent content4, CaseContent content5, CaseContent content6, CaseContent content7, CaseContent content8, CaseContent content9, CaseContent content10, String snippets, int following, int referring) {
    this.id = id;
    this.title = title;
    this.caseNumber = caseNumber;
    this.decisionDate = decisionDate;
    this.tribunalCourt = tribunalCourt;
    this.coram = coram;
    this.counselNames = counselNames;
    this.parties = parties;
    this.content1 = content1;
    this.content2 = content2;
    this.content3 = content3;
    this.content4 = content4;
    this.content5 = content5;
    this.content6 = content6;
    this.content7 = content7;
    this.content8 = content8;
    this.content9 = content9;
    this.content10 = content10;
    this.snippets = snippets;
    this.following = following;
    this.referring = referring;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getCaseNumber() {
    return caseNumber;
  }

  public void setCaseNumber(String caseNumber) {
    this.caseNumber = caseNumber;
  }

  public String getDecisionDate() {
    return decisionDate;
  }

  public void setDecisionDate(String decisionDate) {
    this.decisionDate = decisionDate;
  }

  public String getTribunalCourt() {
    return tribunalCourt;
  }

  public void setTribunalCourt(String tribunalCourt) {
    this.tribunalCourt = tribunalCourt;
  }

  public String getCoram() {
    return coram;
  }

  public void setCoram(String coram) {
    this.coram = coram;
  }

  public String getCounselNames() {
    return counselNames;
  }

  public void setCounselNames(String counselNames) {
    this.counselNames = counselNames;
  }

  public String getParties() {
    return parties;
  }

  public void setParties(String parties) {
    this.parties = parties;
  }

  public CaseContent getContent1() {
    return content1;
  }

  public void setContent1(CaseContent content1) {
    this.content1 = content1;
  }

  public CaseContent getContent2() {
    return content2;
  }

  public void setContent2(CaseContent content2) {
    this.content2 = content2;
  }

  public CaseContent getContent3() {
    return content3;
  }

  public void setContent3(CaseContent content3) {
    this.content3 = content3;
  }

  public CaseContent getContent4() {
    return content4;
  }

  public void setContent4(CaseContent content4) {
    this.content4 = content4;
  }

  public CaseContent getContent5() {
    return content5;
  }

  public void setContent5(CaseContent content5) {
    this.content5 = content5;
  }

  public CaseContent getContent6() {
    return content6;
  }

  public void setContent6(CaseContent content6) {
    this.content6 = content6;
  }

  public CaseContent getContent7() {
    return content7;
  }

  public void setContent7(CaseContent content7) {
    this.content7 = content7;
  }

  public CaseContent getContent8() {
    return content8;
  }

  public void setContent8(CaseContent content8) {
    this.content8 = content8;
  }

  public CaseContent getContent9() {
    return content9;
  }

  public void setContent9(CaseContent content9) {
    this.content9 = content9;
  }

  public CaseContent getContent10() {
    return content10;
  }

  public void setContent10(CaseContent content10) {
    this.content10 = content10;
  }

  public String getSnippets() {
    return snippets;
  }

  public void setSnippets(String snippets) {
    this.snippets = snippets;
  }

  public int getFollowing() {
    return following;
  }

  public void setFollowing(int following) {
    this.following = following;
  }

  public int getReferring() {
    return referring;
  }

  public void setReferring(int referring) {
    this.referring = referring;
  }

  public int getFavourite() {
    return favourite;
  }

  public void setFavourite(int favourite) {
    this.favourite = favourite;
  }

  public static Case getSampleCase() {
    return new Case(
            "Vinmar Overseas (Singapore) Pte Ltd v PTT International Trading Pte Ltd \n" +
                    "[2018] 2 SLR 1271; [2018] SGCA 65",
            "Civil Appeal No 159 of 2017",
            "22 October 2018",
            "Court of Appeal",
            "Sundaresh Menon CJ; Andrew Phang Boon Leong JA; Judith Prakash JA; Tay Yong Kwang JA; Steven Chong JA",
            "Teh Kee Wee Lawrence, Loh Jen Wei and Chan Wai Yi, Kevin (Chen Weiyi) (Dentons Rodyk & Davidson LLP) for the appellant; Ting Yong Hong, Chen Zhida and Dinesh Sabapathy (Rajah & Tann Singapore LLP) for the respondent; Prof Yeo Tiong Min SC (School of Law, Singapore Management University) as amicus curiae.",
            "Vinmar Overseas (Singapore) Pte Ltd — PTT International Trading Pte Ltd",
            new CaseContent("", "Conflict of Laws – Choice of jurisdiction – Exclusive – Plaintiff bringing action in Singapore in breach of exclusive jurisdiction clause – Defendant applying for stay of proceedings in favour of agreed forum – Whether court should grant stay of proceedings\n" +
                    "\n" +
                    "Contract – Contractual terms – Commercial party entering into four contracts with counterparty and counterparty’s parent company in one-year period leading up to contract in issue, all of which included exclusive jurisdiction clause – Contracts all of similar subject matter and concluded in same manner – Whether exclusive jurisdiction clause incorporated by course of dealings into contract in issue\n" +
                    "\n" +
                    "Courts and Jurisdiction – Court judgments – Prospective overruling of court judgments – Court departing from previous authority – Whether doctrine of prospective overruling applied"),
            new CaseContent("Facts", "Between December 2013 and October 2014, Vinmar Overseas (Singapore) Pte Ltd (“Vinmar”) entered into four contracts (“the Four Contracts”) to purchase chemical commodities from PTT International Trading Pte Ltd (“PTT”) and PTT Public Company Limited (“PTT Public”), PTT’s parent company. All of the Four Contracts included an exclusive jurisdiction clause conferring jurisdiction over disputes arising out of the contracts on the High Court of England (“the EJC”).\n" +
                    "\n" +
                    "In November 2014, Vinmar entered into a contract (“the Contract”) to purchase styrene monomer from PTT. According to Vinmar, the EJC was a term of the Contract. The EJC was one of the terms in a written agreement sent by PTT to Vinmar relating to the Contract (“the Written Terms”).\n" +
                    "\n" +
                    "A dispute arose between Vinmar and PTT. Vinmar terminated the Contract. PTT then began proceedings in Singapore (“Suit 99”) against Vinmar. Vinmar applied for a stay of Suit 99 on the basis that the parties had agreed to refer the dispute to the English High Court.\n" +
                    "\n" +
                    "The assistant registrar and the High Court found that the EJC was a term of the Contract, but refused to grant a stay on the basis that Vinmar did not have a genuine defence to PTT’s claim, relying on a line of Court of Appeal authorities for the proposition that the absence of a meritorious defence would suffice to establish strong cause to refuse a stay (“the rule in The Jian He”)."),
            new CaseContent("Held, allowing the appeal:", ""),
            new CaseContent("Applicability of the EJC", "(1)    In an application for a stay of proceedings based on an exclusive jurisdiction clause (an “EJC Application”), the applicant bore the burden of showing a “good arguable case” that an exclusive jurisdiction agreement existed and governed the dispute in question. To establish a “good arguable case”, the applicant had to have the better of the argument, on the evidence before the court, that the agreement existed and applied to the dispute. In this regard, the court was entitled to grapple with questions of law but should not delve into contested factual issues: at [41], [45] and [46].\n" +
                    "\n" +
                    "(2)    Vinmar did not establish a good arguable case that the parties agreed to the Written Terms. There was no meeting of the minds in relation to the Written Terms when PTT sent them to Vinmar, and insufficient evidence that the parties subsequently agreed to the Written Terms: at [51].\n" +
                    "\n" +
                    "(3)    The test for incorporation by a course of dealings was whether, at the time of contracting, each party as a reasonable person was entitled to infer from the past dealings and the actions and the words of the other in the instant case that the term was to be a part of the contract. A high threshold had to be met for a party to be “entitled to infer” that a term sought to be incorporated was part of the contract. Relevant factors included the number of previous contracts, how recent they were, whether they had a similar subject matter and whether they were made in a consistent manner: at [53] to [55].\n" +
                    "\n" +
                    "(4)    A court was entitled to consider a party’s earlier transactions with a company in the same group of companies as the counterparty to the contract in issue in determining if terms were incorporated into the contract in issue: at [56] and [57].\n" +
                    "\n" +
                    "(5)    In general, it would be easier to establish incorporation by a course of dealings where both parties were in business, rather than where one was a consumer. Further, a term might be more easily incorporated if it was not unusual or unreasonable: at [58].\n" +
                    "\n" +
                    "(6)    There was a good arguable case that the EJC was incorporated by the parties’ course of dealings into the Contract. First, in relation to the number of previous contracts and how recent they were, Vinmar had made four contracts in the one-year period leading up to the formation of the Contract with PTT or PTT Public, all of which included the EJC. Second, with regard to the subject matter of the Four Contracts and the way in which they were concluded, all of the Four Contracts were for the purchase of chemical commodities, the contract immediately preceding the Contract had the same subject matter as the Contract, and the Four Contracts were all concluded in the same manner. Third, Vinmar and PTT were both contracting in the course of business and the EJC was not an onerous or unusual term. There was also no evidence that the parties understood that the previous course of dealings did not apply to the Contract. On the contrary, they acted in accordance with that course of dealings, which indicated that they understood that the Contract was made on that basis: at [59] to [62], [64] and [68]."),
            new CaseContent("Restatement of the law", "(7)    In an EJC Application, the overarching test remained that of whether there was “strong cause” to refuse a stay. In determining whether this test was satisfied, the factors laid down in The Eleftheria [1969] 1 Lloyd’s Rep 237 (“the Eleftheria factors”) were relevant considerations. However, in applying the Eleftheria factors, the court should bear in mind that factors relating to the relative convenience of litigation in Singapore and abroad had little weight if they were foreseeable at the time of contracting, and the analysis of factor (d) set out in the present judgment: at [112].\n" +
                    "\n" +
                    "(8)    In determining whether to grant a stay in an EJC Application, the merits of the defence were irrelevant. The rule in The Jian He was inconsistent with the central principle of party autonomy that pervaded the law governing the enforcement of exclusive jurisdiction agreements. It generated uncertainty for commercial parties in the business of international trade. It had led parties to expend significant costs at the interlocutory stage of proceedings and delayed the resolution of disputes. Abandoning the rule in The Jian He would also promote coherence in the law. Further, the doctrinal basis on which the merits of the defence were incorporated into the general test in an EJC Application – the proposition that where there was no genuine defence, the defendant did not genuinely desire trial in the agreed forum – was flawed. An applicant for a stay might desire trial in the agreed forum even if it had no genuine defence: at [113], [114], [116], [117], [119], [120] and [121].\n" +
                    "\n" +
                    "(9)    The concept of abuse of process underlay factor (d) of the Eleftheria factors, which should be interpreted as encapsulating the following inquiry: was the applicant acting abusively in applying for a stay of proceedings? The threshold for abusive conduct was very high; the cases in which factor (d) was fulfilled would be few and far between: at [129] to [131]."),
            new CaseContent("Prospective overruling", "(10)    There was no serious and demonstrable injustice that justified an application of the doctrine of prospective overruling. PTT would suffer some prejudice from the court’s departure from the rule in The Jian He. However, this could be addressed through orders on costs: at [144] and [145]."),
            new CaseContent("Outcome of the appeal", "(11)    The abuse of process ground for refusing a stay was not made out. There was no strong cause to refuse a stay of Suit 99. The court therefore ordered a stay of Suit 99. There would be no order as to costs for the appeal, and the costs orders below would remain: at [147], [148(b)] and [149].\n" +
                    "\n" +
                    "[Observation: Factor (d) of the Eleftheria factors might apply where an applicant had clearly admitted to the claim as regards both liability and quantum, but sought a stay for no reason other than its alleged inability to pay. It might also apply if the applicant for the stay had started a media campaign in the agreed forum to malign the plaintiff, thus undermining the prospects of a fair trial: at [131].\n" +
                    "\n" +
                    "A stay of proceedings might be refused on the ground of denial of justice. This might be made out, for example, if the agreed court had been dissolved by the time the dispute arose, or was not realistically available to determine the dispute because war had broken out in the jurisdiction. Further, there might be some very exceptional cases where trial in the agreed court would be so overwhelmingly difficult or inconvenient that a stay would effectively deny the plaintiff access to justice. However, notorious delay in the judicial system of the agreed forum would generally not suffice in and of itself to constitute denial of justice: at [133] and [134].\n" +
                    "\n" +
                    "The issue of whether the court’s restatement of the law applied equally to jurisdiction clauses in bills of lading and standard form contracts that the plaintiff was not in a position to negotiate was left open for determination in a subsequent case: at [138].\n" +
                    "\n" +
                    "Where the grant of a stay would lead to the fragmentation of a dispute across multiple jurisdictions because the dispute involved multiple parties, some of whom were not parties to the jurisdiction clause, the risk of duplicative proceedings, inconsistent findings and incentivising a rush to judgment might well established strong cause to refuse a stay. The concern arising from such fragmentation of legal proceedings was legitimate and certainly one which merited proper consideration with the benefit of submissions, should the issue arise in a subsequent case: at [139].\n" +
                    "\n" +
                    "A plaintiff would only be able to rely on the fact that its claim was time-barred in the agreed forum to establish strong cause against a stay if there were very good reasons why it did not file a protective writ. Absent a very compelling reason, the expiry of a time bar in the contractual forum would have been self-induced, by the plaintiff’s choice to sue in a non-contractual forum in breach of the exclusive jurisdiction agreement: at [141].]"),
            new CaseContent("Case(s) referred to", "Adri Anton Kalangie v PP [2018] 2 SLR 557 (folld)\n" +
                    "\n" +
                    "Amerco Timbers Pte Ltd v Chatsworth Timber Corp Pte Ltd [1977–1978] SLR(R) 112; [1975–1977] SLR 258 (folld)\n" +
                    "\n" +
                    "Asian Plutus, The [1990] 1 SLR(R) 504; [1990] SLR 543 (refd)\n" +
                    "\n" +
                    "Atlantic Song, The [1983] 2 Lloyd’s Rep 394 (not folld)\n" +
                    "\n" +
                    "Bols Distilleries BV v Superior Yacht Services Ltd [2007] 1 WLR 12 (refd)\n" +
                    "\n" +
                    "Bradley Lomas Electrolok Ltd v Colt Ventilation East Asia Pte Ltd [1999] 3 SLR(R) 1156; [2000] 1 SLR 673 (folld)\n" +
                    "\n" +
                    "Canada Trust Co v Stolzenberg (No 2) [1998] 1 WLR 547 (refd)\n" +
                    "\n" +
                    "Capes (Hatherden) Ltd v Western Arable Services Ltd [2010] 1 Lloyd’s Rep 477 (refd)\n" +
                    "\n" +
                    "CH Offshore Ltd v PDV Marina SA [2015] EWHC 595 (Comm) (refd)\n" +
                    "\n" +
                    "Circle Freight International Ltd v Medeast Gulf Exports Ltd [1988] 2 Lloyd’s Rep 427 (refd)\n" +
                    "\n" +
                    "Deltatre Spa v Hong Kong Sports Industrial Development Ltd [2018] HKCU 2939 (refd)\n" +
                    "\n" +
                    "Donohue v Armco Inc [2002] 1 Lloyd’s Rep 425 (refd)\n" +
                    "\n" +
                    "Eleftheria, The [1969] 1 Lloyd’s Rep 237 (refd)\n" +
                    "\n" +
                    "Euromark Ltd v Smash Enterprises Pty Ltd [2013] EWHC 1627 (QB) (refd)\n" +
                    "\n" +
                    "Frank Pais, The [1986] 1 Lloyd’s Rep 529 (not folld)\n" +
                    "\n" +
                    "Golden Shore Transportation Pte Ltd v UCO Bank [2004] 1 SLR(R) 6; [2004] 1 SLR 6 (not folld)\n" +
                    "\n" +
                    "Hayter v Nelson and Home Insurance Co [1990] 2 Lloyd’s Rep 265 (refd)\n" +
                    "\n" +
                    "Henry Kendall & Sons v William Lillico & Sons Ltd [1969] 2 AC 31 (refd)\n" +
                    "\n" +
                    "Hollier v Rambler Motors (AMC) Ltd [1972] 2 QB 71 (refd)\n" +
                    "\n" +
                    "Hung Vuong-2, The [2000] 2 SLR(R) 11; [2001] 3 SLR 146 (not folld)\n" +
                    "\n" +
                    "Hyundai Engineering & Construction Co Ltd v UBAF (Hong Kong) Ltd [2013] HKCU 2237 (refd)\n" +
                    "\n" +
                    "Hyundai Fortune, The [2004] 4 SLR(R) 548; [2004] 4 SLR 548 (refd)\n" +
                    "\n" +
                    "Incitec Ltd v Alkimos Shipping Corp (2004) 206 ALR 558 (refd)\n" +
                    "\n" +
                    "Jian He, The [1999] 3 SLR(R) 432; [2000] 1 SLR 8 (not folld)\n" +
                    "\n" +
                    "Joint Stock Co “Aeroflot Russian Airlines” v Berezovsky [2013] 2 Lloyd’s Rep 242 (refd)\n" +
                    "\n" +
                    "JTrust Asia Pte Ltd v Group Lease Holdings Pte Ltd [2018] 2 SLR 159 (refd)\n" +
                    "\n" +
                    "L Capital Jones Ltd v Maniach Pte Ltd [2017] 1 SLR 312 (refd)\n" +
                    "\n" +
                    "Lisnave Estaleiros Navais SA v Chemikalien Seetransport GmbH [2013] 2 Lloyd’s Rep 203 (refd)\n" +
                    "\n" +
                    "Q & M Enterprises Sdn Bhd v Poh Kiat [2005] 4 SLR(R) 494; [2005] 4 SLR 494 (refd)\n" +
                    "\n" +
                    "Rainbow Joy, The [2005] 3 SLR(R) 719; [2005] 3 SLR 719 (refd)\n" +
                    "\n" +
                    "SIAT Di Del Ferro v Tradax Overseas SA [1978] 2 Lloyd’s Rep 470, HC (folld)\n" +
                    "\n" +
                    "SIAT Di Dal Ferro v Tradax Overseas SA [1980] 1 Lloyd’s Rep 53, CA (refd)\n" +
                    "\n" +
                    "Standard Chartered Bank v Pakistan National Shipping Corp [1995] 2 Lloyd’s Rep 365 (not folld)\n" +
                    "\n" +
                    "Tjong Very Sumito v Antig Investments Pte Ltd [2009] 4 SLR(R) 732; [2009] 4 SLR 732 (refd)\n" +
                    "\n" +
                    "Transformers & Rectifiers Ltd v Needs Ltd [2015] EWHC 269 (TCC) (refd)\n" +
                    "\n" +
                    "Vishva Apurva, The [1992] 1 SLR(R) 912; [1992] 2 SLR 175 (folld)\n" +
                    "\n" +
                    "Vishva Prabha, The [1979] 2 Lloyd’s Rep 286 (not folld)\n" +
                    "\n" +
                    "Xu Ziming v Ruifeng Petroleum Chemical Holdings Ltd [2014] HKCU 2013, CFI (not folld)\n" +
                    "\n" +
                    "Xu Ziming v Ruifeng Petroleum Chemical Holdings Ltd [2014] HKCU 2958, CFI (not folld)\n" +
                    "\n" +
                    "ZI Pompey Industrie v Ecu-Line NV (2003) 224 DLR (4th) 577 (refd)"),
            new CaseContent("Legislation referred to", "International Arbitration Act (Cap 143A, 2002 Rev Ed) ss 6, 6(2)\n" +
                    "\n" +
                    "Rules of Court (Cap 322, R 5, 2014 Rev Ed) O 11r 1\n" +
                    "\n" +
                    "22 October 2018\n" +
                    "\n" +
                    "Judgment reserved."),
            new CaseContent("Steven Chong JA (delivering the judgment of the court):", "1       Exclusive jurisdiction clauses are ubiquitous provisions in international commercial contracts. Owing to the transnational dimensions of such contracts, including the nationalities of the parties and the place(s) of performance, parties typically agree to refer all disputes arising from such contracts to a particular jurisdiction in an effort to avoid disputes over the proper forum. Quite often, to minimise or eliminate any disagreement over the effect of such clauses, parties would provide for the selected forum to have exclusive jurisdiction.\n" +
                    "\n" +
                    "2       Regardless of the reason for the choice of the agreed forum, an exclusive jurisdiction clause has full contractual force unless and until it is invalidated. However, courts have somewhat whittled down the contractual force of such clauses. Where a plaintiff begins proceedings in breach of an exclusive jurisdiction clause, and the defendant applies for a stay on the basis of the clause, the court may examine the merits of the claim in order to determine whether there is any purpose in staying the proceedings. Such an approach has been rationalised on the basis that absent any merits in the defence, a defendant does not genuinely desire trial in the selected foreign court and accordingly, the court should exercise its discretion to refuse a stay. To hold otherwise, the courts have reasoned, would be to permit an abuse of process.\n" +
                    "\n" +
                    "3       Yet this approach would only be consistent with the parties’ jurisdiction agreement if the parties had intended the jurisdiction clause to apply only in the event of a genuine dispute. In other words, the approach assumes that the parties intended to exclude the application of the clause in the most obvious cases of liability. Such a theory does not accord with commercial reality. In agreeing to an exclusive jurisdiction clause, the parties express a clear desire in advance of any dispute that a selected court will hear the case whatever the merits of the claim. This must be so because parties would have no idea how a dispute would arise or pan out.\n" +
                    "\n" +
                    "4       There can be no doubt that parties attach considerable importance to exclusive jurisdiction clauses. This is entirely understandable as they are usually an integral part of the commercial agreement, without which the agreement may never have been formed. The fact that parties place much significance on such clauses is perhaps best exemplified by the volume of stay applications reaching this court for final determination. The volume of these cases may well have been the unintended consequence of the existing law. Much time and resources have been expended to address the hitherto crucial merits issue.\n" +
                    "\n" +
                    "5       This appeal raises the interesting issue of whether we should depart from a long line of authorities laid down by this court, where we held that the merits of a defence, or lack thereof, are relevant in deciding whether proceedings should be stayed to give effect to an exclusive jurisdiction clause. In the courts below, the assistant registrar (“the AR”) and the High Court judge (“the Judge”) found themselves bound by this line of precedents, and thus dismissed the application for a stay in favour of the English High Court. Given the importance of the issue at hand, we appointed Prof Yeo Tiong Min SC (“Prof Yeo”) as amicus curiae. Prof Yeo’s excellent submissions greatly assisted us in our deliberations."),
            "...had purchased it on 1st June, 1920, subject to a charge dated 2nd March, 1920, to K. V.... ...charge dated 2nd March, 1920, to K. V. A. Vengadasalum Chetty for $9,000. Tan See Kee... ...of Title No. 1183 charged it to K. V. A. Vellayappa Chetty for $30,000. The charge was... ...were both agents of the firm of K. V. A.",
            1,
            1,
            0
    );
  }

  @Override
  public String toString() {
    return "Case{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", caseNumber='" + caseNumber + '\'' +
            ", decisionDate='" + decisionDate + '\'' +
            ", tribunalCourt='" + tribunalCourt + '\'' +
            ", coram='" + coram + '\'' +
            ", counselNames='" + counselNames + '\'' +
            ", parties='" + parties + '\'' +
            ", content1=" + content1 +
            ", content2=" + content2 +
            ", content3=" + content3 +
            ", content4=" + content4 +
            ", content5=" + content5 +
            ", content6=" + content6 +
            ", content7=" + content7 +
            ", content8=" + content8 +
            ", content9=" + content9 +
            ", content10=" + content10 +
            ", snippets='" + snippets + '\'' +
            ", following=" + following +
            ", referring=" + referring +
            ", favourite=" + favourite +
            '}';
  }
}
