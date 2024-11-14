package com.example.ca3

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TopicActivity : AppCompatActivity() {
    private lateinit var subtopicsAdapter: ArrayAdapter<String>
    private val subtopics = mutableListOf<String>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_topic)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val topic = intent.getStringExtra("topic")
        findViewById<TextView>(R.id.tvTopicTitle).text = topic

        val topicImageView = findViewById<ImageView>(R.id.ivTopicImage)
        setTopicImage(topic, topicImageView)

        subtopics.addAll(getSubtopicsForTopic(topic))

        subtopicsAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, subtopics)
        findViewById<ListView>(R.id.lvSubtopics).adapter = subtopicsAdapter

        findViewById<ListView>(R.id.lvSubtopics).setOnItemClickListener { _, _, position, _ ->
            val subtopicTitle = subtopics[position]
            val subtopicContent = getSubtopicContent(subtopicTitle)
            val intent = Intent(this, SubtopicDetailActivity::class.java)
            intent.putExtra("subtopicTitle", subtopicTitle)
            intent.putExtra("subtopicContent", subtopicContent)
            startActivity(intent)
        }
        findViewById<Button>(R.id.btnTakeQuiz).setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
        }
    }

    private fun getSubtopicsForTopic(topic: String?): List<String> {
        return when (topic) {
            "Investment Basics" -> listOf("1.1 What Is Investing & Why Should One Invest?","1.2 Risk Associated With Investing","1.3 When To Start Investing?","1.4 What Care Should One Take While Investing?","1.5 Types Of Investment Instruments","1.6 Saving Or Investment – The Better Option","1.7 Where Are The Investments Instruments Traded?","1.8 What Is An Index?","1.9 Types Of Stock Market Indices?")
            "Securities" -> listOf("2.1 What Is Meant By Securities?","2.2 What Is The Function Of The Securities Market?","2.3 Who Regulates The Securities Market?","2.4 What Is SEBI And Its Role?","2.5 Who Are The Participants In The Securities Market?","2.6 Financial Intermediaries","2.7 Where Are The Segments of The Securities Market?")
            "Primary Market" -> listOf("3.1 What Is A Primary Market & Functions Of Primary Market", "3.2 Different Methods Of Raising Capital In Primary Market?", "3.3 Public Issue", "3.4 Private Placements", "3.5 Rights Offering", "3.6 Bonus Issue", "3.7 Difference Between Bonus Shares & Rights Issue", "3.8 Participants in Primary Market", "3.9 Value at which Securities are Issued in Primary Market")
            "IPO Basics" -> listOf("4.1 What Is An IPO & Why Do Companies Go Public?", "4.2 Advantages Of Going Public & The Process For An IPO?", "4.3 What Is An IPO Procedure In India?", "4.4 Book Building Process v/s Fixed Price Mechanism", "4.5 How Can Investor Invest In IPOs?", "4.6 How Are Shares Allotted?", "4.7 What Should The Investors Look Into Red Herring Prospectus")
            "Secondary Market" -> listOf("5.1 What Is Meant By Secondary Market?",
                "5.2 Types Of Secondary Market – Exchanges & OTC",
                "5.3 Trading In Secondary Markets",
                "5.4 What Is The Role Of A Stock Exchange In Secondary Market?",
                "5.5 Why Should One Trade On A Recognized Stock Exchange?",
                "5.6 How To Place Orders With The Brokers",
                "5.7 Understanding Trading Platforms",
                "5.8 Getting Started With Trading Platforms",
                "5.9 What Is The Concept Of Brokerage?",
                "5.10 Charges That Comprise of Net Trading Cost?")
            "Products in Secondary Market" -> listOf("6.1 What Are The Products Dealt In Secondary Market?",
                "6.2 Why Should One Invest In Equities In Particular?",
                "6.3 What Has Been The Average Return On Equities In India?",
                "6.4 What Are The Factors That Influence The Price of A Stock?",
                "6.5 Difference Between The Term Growth Stock V/s Value Stock?",
                "6.6 What Is A Portfolio?",
                "6.7 What Is Diversification?",
                "6.8 What Are The Advantages Of A Diversified Portfolio?",
                "6.9 What Is A Debt Instrument?",
                "6.10 What Are The Features Of Debt Instruments?")
                "Derivatives" -> listOf("7.1 What Are The Types Of Derivatives?",
                "7.2 Participants In Derivatives Market",
                "7.3 What Is An Option Premium?",
                "7.4 What Is Meant By Commodity?")
            "Depositories" -> listOf("8.1 What Is A Depository?",
                "8.2 How Is A Depository Similar To A Bank?",
                "8.3 Services Provided By A Depository",
                "8.4 Who Is A Depository Participant?",
                "8.5 What Is An ISIN?",
                "8.6 What Is A Custodian?",
                "8.7 Can Electronic Holding Be Converted Into Physical Certificates?")
            "Mutual Funds" -> listOf("9.1 What Are Mutual Funds?",
                "9.2 Who Is The Regulatory Body For Mutual Funds?",
                "9.3 What Is NAV?",
                "9.4 Risks Involved In Mutual Funds?",
                "9.5 What Are The Different Types of Mutual Funds?",
                "9.6 What Are The Rights That Are Available To Mutual Funds Holders In India?",
                "9.7 What Is A Fund Offer Document?",
                "9.8 What Is Active Fund Management?",
                "9.9 What Is Passive Fund Management?",
                "9.10 What Is An ETF?",
                "9.11 Must Know Concepts")
            else -> emptyList()
        }
    }

    private fun getSubtopicContent(subtopicTitle: String): String {
        return when (subtopicTitle) {
            "1.1 What Is Investing & Why Should One Invest?" -> "Investing is the process of allocating money or resources into an asset or security with the expectation of generating income or capital appreciation over time. It involves purchasing assets like stocks, bonds, real estate, or mutual funds, with the goal of growing wealth. One should invest to achieve long-term financial goals, such as retirement planning, buying a home, or funding education. Unlike saving, investing offers the potential for higher returns, but it comes with higher risks. By investing, individuals can take advantage of compounding, inflation-beating returns, and diversify their financial portfolio."
            "1.2 Risk Associated With Investing" -> "Investing involves various risks, including market risk, credit risk, liquidity risk, interest rate risk, and inflation risk.  \n"+
            "- Market risk refers to the potential for an investment’s value to decrease due to overall market conditions or fluctuations.\n"+
                    "- Credit risk is the possibility that the issuer of a bond or debt instrument might default on payments.\n"+
                    "- Liquidity risk involves the difficulty of quickly selling an asset without affecting its price.\n"+
                    "- Interest rate risk impacts bond prices, which tend to fall when interest rates rise.\n"+
                    "- Inflation risk arises when the returns on investments fail to outpace inflation, eroding purchasing power. Understanding these risks is essential for making informed investment decisions."

            "1.3 When To Start Investing?" -> "The best time to start investing is as soon as possible, ideally when you have some savings set aside. Early investing allows you to take advantage of the power of compounding, where the returns on your investments start to generate their own returns over time. The earlier you begin, the more time your money has to grow. Even small amounts invested regularly can accumulate into substantial wealth over the long term. However, before starting, it’s important to have a clear understanding of your financial goals, risk tolerance, and an emergency fund in place."

            "1.4 What Care Should One Take While Investing?" -> "When investing, one should take several precautions to manage risks effectively and maximize potential returns:  \n"+
            "- Diversify : Spread investments across various asset classes (stocks, bonds, real estate) to reduce risk.\n"+
            "- Research : Understand the asset before investing, including its potential risks and returns.\n"+
                    "- Set Clear Goals : Determine your investment objectives, such as retirement, education, or wealth accumulation.\n"+
            "- Assess Risk Tolerance : Choose investments based on your ability to withstand market fluctuations.\n"+
            "- Monitor Investments : Regularly review your portfolio to ensure it aligns with your goals and make adjustments when necessary.\n"+
            "- Avoid Emotional Decisions : Stay calm during market volatility and stick to your long-term plan."

            "1.5 Types Of Investment Instruments" -> "Investment instruments refer to the various assets that individuals can invest in. Some common types include:  \n"+
            "- **Stocks**: Shares in a company that represent ownership and provide potential for capital gains and dividends.\n"+
            "- **Bonds**: Debt securities issued by governments or corporations, offering regular interest payments.\n"+
             "- **Mutual Funds**: Pooled investment vehicles that allow investors to invest in a diversified portfolio of stocks, bonds, or other assets.\n"+
            "- **Real Estate**: Physical property investments that can generate rental income or appreciate in value.\n"+
            "- **Commodities**: Physical goods like gold, oil, or agricultural products that are traded on exchanges.\n"+
             "- **ETFs (Exchange-Traded Funds)**: Investment funds that hold assets like stocks or bonds and trade on stock exchanges."

            "1.6 Saving Or Investment – The Better Option" -> "Saving and investing are both important financial strategies, but they serve different purposes. Saving typically involves putting money into low-risk, low-return accounts like savings accounts or fixed deposits to preserve capital and provide liquidity for short-term goals. Investment, on the other hand, involves allocating money to assets with the potential for higher returns, but with greater risk, for long-term financial growth.\n"+
            "While saving is suitable for short-term goals and emergencies, investing is a better option for growing wealth over time and achieving long-term goals like retirement. Ideally, a combination of both strategies should be used."
                "1.7 Where Are The Investments Instruments Traded?" -> "Investment instruments are traded in various financial markets and platforms, including:\n"+
            "- **Stock Exchanges**: Public markets like the **New York Stock Exchange (NYSE), NASDAQ, **Bombay Stock Exchange (BSE)**, and **National Stock Exchange (NSE)** where stocks, bonds, and ETFs are bought and sold.\n"+
             "- **Bond Markets**: Over-the-counter markets or exchanges where government and corporate bonds are traded.\n"+
            "- **Commodities Markets**: Exchanges like the **Chicago Mercantile Exchange (CME) or **Multi Commodity Exchange (MCX), where commodities like gold, oil, and agricultural products are traded.\n"+
            "- **Real Estate Markets**: Physical property transactions or real estate investment trusts (REITs) that are traded on stock exchanges.\n"+
           "- **Forex Markets**: The global marketplace for trading currencies, usually in a decentralized manner."
            "1.8 What Is An Index?"-> "An index is a statistical measure that tracks the performance of a group of stocks, bonds, or other assets. It reflects the overall movement of a market or a specific sector. Examples include stock market indices like the **S&P 500**, which tracks 500 large companies in the U.S., or the **Dow Jones Industrial Average**, which tracks 30 significant companies. Indices provide investors with a benchmark to compare the performance of their investments, gauge the health of an economy, and offer a broad view of market trends. Indices can be weighted by market capitalization or price."
            "1.9 Types Of Stock Market Indices?" -> "There are several types of stock market indices, each serving different purposes:\n"+
            "- Price-Weighted Indices**: The value of the index is based on the stock prices of the companies it tracks. An example is the Dow Jones Industrial Average (DJIA).\n"+
                    "- Market Capitalization-Weighted Indices : These indices are weighted according to the market capitalization of the companies, meaning larger companies have a greater impact on the index. An example is the S&P 500.\n"+
                    "- Equal-Weighted Indices: Every stock in the index contributes equally to the performance, regardless of its market size.\n"+
           "- Sectoral Indices : These track the performance of specific sectors, such as technology, healthcare, or finance. Examples include the **NASDAQ-100** and **NIFTY IT.\n"+
                    "Each type of index provides investors with a different perspective on the stock market or specific industry performance."
            "2.1 What Is Meant By Securities?" -> "Securities are tradable financial instruments that hold value and can be bought or sold in financial markets. They represent ownership (equity securities like stocks), debt (debt securities like bonds), or derivatives (contracts based on the value of an underlying asset). Securities are a way for companies, governments, and other entities to raise capital and for investors to gain ownership or earn returns. In essence, they are investments that offer investors a claim on the future income or profits of an issuer, depending on the type of security."
            "2.2 What Is The Function Of The Securities Market?" -> "The securities market serves several critical functions in the economy. First, it provides a platform for raising capital, allowing companies and governments to issue stocks and bonds to the public. This enables them to finance projects, operations, or infrastructure. Second, it offers liquidity by providing a venue where securities can be bought and sold, giving investors the ability to easily enter or exit positions. The market also helps in price discovery, where the forces of supply and demand determine the value of securities. Additionally, the securities market fosters transparency and promotes economic growth by attracting investment."
            "2.3 Who Regulates The Securities Market?" -> "The securities market is regulated by government agencies or regulatory bodies that oversee its functioning to ensure fairness, transparency, and investor protection. In India, the primary regulatory body is the **Securities and Exchange Board of India (SEBI)**, while in the United States, it is the **Securities and Exchange Commission (SEC)**. These organizations are responsible for ensuring that securities markets operate smoothly, that companies adhere to disclosure requirements, and that investors are protected from fraudulent activities. They also establish rules and regulations to promote market integrity and prevent manipulation."
            "2.4 What Is SEBI And Its Role?" -> "SEBI (Securities and Exchange Board of India) is the regulatory body for the securities market in India. Established in 1988 and granted statutory powers in 1992, SEBI’s primary role is to protect the interests of investors and promote the development of the securities market. SEBI regulates and supervises stock exchanges, brokers, and other market intermediaries to ensure fairness and transparency in the market. It also works to prevent insider trading, market manipulation, and fraudulent activities. SEBI's role extends to formulating regulations that govern the functioning of the securities market, ensuring that investors are informed and that market practices are ethical."
            "2.5 Who Are The Participants In The Securities Market?" -> "Participants in the securities market include a variety of individuals and institutions who play different roles in the trading process. The key participants are:\n"+
            "- Investors : Individuals or institutions that buy and sell securities to earn returns.\n"+
            "- Issuers : Companies, governments, or other entities that issue securities to raise capital.\n"+
            "- Brokers and Dealers : Intermediaries who facilitate the buying and selling of securities between investors.\n"+
                    "- Underwriters : Investment banks or financial institutions that help issuers bring securities to the market, often by purchasing securities for resale.\n"+
            "- Regulators : Bodies like SEBI that ensure compliance with rules and regulations to maintain fair market practices.\n"+
                    "- Stock Exchanges : Platforms where securities are listed and traded, providing a marketplace for buyers and sellers."

                "2.6 Financial Intermediaries" -> "Financial intermediaries are institutions or individuals that act as middlemen between investors and companies or governments seeking capital. They help facilitate the flow of funds by matching savers with borrowers, reducing transaction costs, and improving market efficiency. Examples of financial intermediaries include **banks**, **mutual funds**, **insurance companies**, **pension funds**, **investment banks**, and **brokers**. These intermediaries offer services such as portfolio management, advisory, underwriting, and risk management, and they play a crucial role in providing liquidity, managing risk, and allocating capital in the financial system."

                "2.7 Where Are The Segments of The Securities Market?" -> "The securities market is typically divided into two main segments:  \n"+
            "1. Primary Market : This is where new securities are issued for the first time, allowing companies, governments, or other entities to raise capital. In this market, investors can directly buy securities from the issuer through mechanisms like IPOs (Initial Public Offerings) or bond issuances.\n"+
               " 2. Secondary Market : This is where previously issued securities are bought and sold between investors. The secondary market provides liquidity and the ability for investors to trade securities on exchanges like the Bombay Stock Exchange (BSE) or the National Stock Exchange (NSE) in India, or the New York Stock Exchange (NYSE) in the U.S.\n"+
                    "These segments ensure the efficient flow of capital and liquidity within the financial system."
            "3.1 What Is A Primary Market & Functions Of Primary Market" -> "The primary market is a financial market where new securities are issued for the first time. It serves as the gateway for companies to raise capital by selling shares, bonds, or other financial instruments to investors. The primary market’s main functions include capital formation, where businesses can acquire the necessary funds for expansion or operational needs, and price discovery, where the market determines the initial price of a security based on investor demand. Additionally, the primary market ensures liquidity and provides a platform for businesses to establish themselves in the capital markets."
            "3.2 Different Methods Of Raising Capital In Primary Market?" -> "In the primary market, companies can raise capital through various methods, including **public issues**, **private placements**, **rights issues**, **bonus issues**, and **shelf registrations**.  \n"+
            "- Public issues involve the offering of new shares or bonds to the general public through an IPO or FPO (Follow-on Public Offer).\n"+
            "- Private placements refer to the direct sale of securities to a select group of institutional or accredited investors.\n"+
            "- Rights issues allow existing shareholders the option to purchase additional shares, typically at a discounted price.\n"+
            "- Bonus issues involve issuing free shares to current shareholders, often to capitalize on accumulated profits.\n"+
                    "- Shelf registrations** allow companies to file a registration for securities to be issued at a later time."
            "3.3 Public Issue" -> "A public issue is a method used by companies to raise capital by offering new shares or bonds to the general public through an IPO (Initial Public Offering) or FPO (Follow-on Public Offering). In an IPO, a company offers its shares to the public for the first time, while in an FPO, a company that is already publicly listed offers additional shares. Public issues allow companies to raise large amounts of capital and provide liquidity for existing shareholders. The process is heavily regulated and involves preparing a prospectus, pricing the issue, and marketing the offering to attract investors."
            "3.4 Private Placements" -> "Private placements are an alternative to public offerings, where securities are sold directly to a select group of institutional or accredited investors, rather than to the general public. This method allows companies to raise capital without the need for extensive regulatory filings or the public disclosure required in public issues. Private placements are faster and more flexible but may limit the company’s access to a broad range of investors. It is commonly used by smaller companies, startups, or large organizations seeking a quick infusion of capital from institutional investors like private equity firms, hedge funds, or pension funds."
            "3.5 Rights Offering" -> "A rights offering is a method for a company to raise capital by giving existing shareholders the right to purchase additional shares at a discounted price, typically in proportion to their existing holdings. This allows shareholders to maintain their ownership percentage in the company. Rights offerings are often used when a company needs to raise capital quickly, and they provide a way for existing shareholders to benefit from a discounted share price. However, those who do not exercise their rights may see their shareholding percentage diluted. The rights are typically tradable, allowing shareholders to sell them if they do not want to purchase additional shares."
            "3.6 Bonus Issue" -> "A bonus issue is a method by which a company issues additional shares to existing shareholders without any payment, typically in proportion to the shares already held. Bonus shares are issued from a company’s reserves or accumulated profits and are given to shareholders as a way to distribute profits without paying cash. While a bonus issue increases the number of shares outstanding, it does not change the overall value of the investor’s holdings, as the share price is adjusted to reflect the increased number of shares. Bonus issues are often seen as a signal of a company’s strong financial position and are used to reward shareholders."
            "3.7 Difference Between Bonus Shares & Rights Issue" -> "The key difference between **bonus shares** and a **rights issue** lies in the way the shares are distributed and the cost to the shareholders:\n"+
            "- Bonus shares are issued to existing shareholders for free, typically from the company’s retained earnings or reserves. Shareholders receive additional shares in proportion to their current holdings without having to pay anything for them.\n"+
            "- Rights issue, on the other hand, offers shareholders the opportunity to buy additional shares at a discounted price, often below the market price. Shareholders must pay for the new shares, and the offering is usually done to raise fresh capital for the company. While bonus shares do not require payment, rights issues do, leading to the potential for dilution if the rights are not exercised."
            "3.8 Participants in Primary Market" -> "The primary market involves various participants who play distinct roles in the capital raising process: \n"+
                    "- Issuers : Companies or entities that issue securities to raise capital.\n"+
            "- Investors : Individuals, institutional investors, and mutual funds that purchase the securities being issued.\n"+
            "- Underwriters : Financial institutions or investment banks that help companies prepare for and manage the offering process, often taking on the risk of buying the securities and selling them to investors.\n"+
                    "- Regulatory Bodies : Organizations like the Securities and Exchange Board of India (SEBI) or the Securities and Exchange Commission (SEC) that oversee the offering process to ensure transparency and fairness.\n"+
            "- Stock Exchanges : Platforms where securities are listed and traded after being issued in the primary market."
            "3.9 Value at which Securities are Issued in Primary Market" -> "The value at which securities are issued in the primary market is determined through several methods, with the most common being price discovery and valuation techniques.\n"+
                    "- In a public issue, the price may be set through the **Book Building Process** or **Fixed Price Mechanism.\n"+
            "- In the Book Building Process, the price is determined based on investor demand within a specified price range, allowing the market to determine the fair value of the securities.\n"+
            "- In the Fixed Price Mechanism, the price is set in advance by the company and underwriters, and all investors pay the same price for the securities.\n"+
                    "For rights issues, the issue price is typically set below the market price to attract existing shareholders. The issue price is often discounted to reflect the value proposition and increase investor participation."

                "4.1 What Is An IPO & Why Do Companies Go Public?" -> "An IPO (Initial Public Offering) is the process by which a private company offers shares of its stock to the public for the first time. The company goes public by listing its shares on a stock exchange, making it accessible for individuals and institutional investors to buy and sell. Companies go public to raise capital for expansion, pay off debt, or invest in research and development. Going public also enhances a company’s visibility and credibility, providing access to a broader pool of investors. IPOs allow private investors and founders to realize a return on their investment."

                "4.2 Advantages Of Going Public & The Process For An IPO?" -> "Going public through an IPO offers several advantages. First, it raises significant capital that can be used for business expansion, debt reduction, or acquisitions. It also provides increased visibility, credibility, and the ability to attract top talent by offering stock options. The IPO process involves several steps: choosing an investment bank to act as the underwriter, preparing the necessary financial documents, conducting due diligence, and filing a registration statement with the Securities and Exchange Commission (SEC) or the respective regulatory body. Once approved, the company sets a price for the shares and launches the public offering."

                "4.3 What Is An IPO Procedure In India?" -> "In India, the IPO procedure follows a regulated process governed by the Securities and Exchange Board of India (SEBI). The company begins by appointing an investment banker, known as the lead manager, who helps in drafting the **Draft Red Herring Prospectus (DRHP)**. The company then files the DRHP with SEBI for approval. Once SEBI clears the DRHP, the company can advertise the IPO, and investors can apply for shares through brokers or online platforms. After the IPO is closed, the company allocates shares to investors and lists them on the stock exchange. The entire process typically takes a few months."

                "4.4 Book Building Process v/s Fixed Price Mechanism "-> "In an IPO, the method of pricing shares can be either the Book Building Process** or the Fixed Price Mechanism.\n"+
            "- In the Book Building Process, the company and its underwriters set a price range for the shares, and investors bid within that range. The final price is determined by the demand at different price levels, allowing for a market-driven approach to pricing.\n"+
            "- In the Fixed Price Mechanism, the price of shares is set before the IPO opens, and all investors pay the same price. This method provides certainty about the cost but does not allow for the flexibility of adjusting to market demand. The Book Building Process is more commonly used in India due to its ability to reflect investor demand accurately."

                "4.5 How Can Investor Invest In IPOs?" -> "Investors can invest in IPOs through their Demat account and **trading account**. To participate, an investor must first have a valid Demat and trading account with a registered broker. Once the IPO opens, investors can place their bids through their broker’s platform or online trading system. Investors can either apply for IPO shares at the fixed price or participate in the book-building process by bidding within the given price range. After the IPO is closed, the shares are allotted, and if the investor’s bid is successful, the shares are credited to their Demat account."

                "4.6 How Are Shares Allotted?" -> "Shares in an IPO are allotted based on the demand and the type of bidding process. In the Fixed Price Mechanism, shares are allotted at the predetermined price to all successful applicants. In the **Book Building Process**, the shares are allotted based on the demand at various price levels, and the final price is determined after the book-building process concludes. If an IPO is oversubscribed, the allotment is done on a pro-rata basis, meaning each applicant will receive a portion of the total shares based on the number of shares they applied for relative to the total demand."

                "4.7 What Should The Investors Look Into Red Herring Prospectus" -> "The **Red Herring Prospectus (RHP)** is a crucial document for investors considering participating in an IPO. It provides detailed information about the company, including its financial performance, business model, risks, and the intended use of the proceeds from the IPO. Investors should look for the following key areas in the RHP: \n"+
            "1. Company Overview: Understanding the company’s business, operations, and competitive advantages.\n"+
            "2. Financial Statements: Review of the company’s revenue, profit, debts, and cash flow.\n"+
            "3. Risk Factors: Insights into any challenges or uncertainties the company may face.\n"+
            "4. Use of Proceeds: How the company plans to use the money raised from the IPO.\n"+
            "5. Management Team: Information about the company’s leadership and their qualifications.\n"+
            "A thorough review of the RHP can help investors make informed decisions about whether to invest in the IPO."
                "5.1 What Is Meant By Secondary Market?" -> "The secondary market is a financial market where previously issued securities, such as stocks and bonds, are bought and sold. Unlike the primary market, where securities are issued for the first time to raise capital, the secondary market allows investors to trade securities among themselves. This market provides liquidity, enabling investors to easily buy or sell their holdings at market prices. It plays a vital role in price discovery and ensures that capital raised in the primary market can be transferred efficiently across investors."

                "5.2 Types Of Secondary Market – Exchanges & OTC" -> "The secondary market can be divided into two main types: **Exchanges** and **Over-the-Counter (OTC)** markets. **Exchanges**, like the New York Stock Exchange (NYSE) or the Nasdaq, are centralized, regulated platforms where buyers and sellers meet to trade securities. They provide transparency, liquidity, and standardization. **OTC markets** are decentralized markets where trading happens directly between parties, often with less regulation. OTC markets are used for securities not listed on exchanges, such as smaller or more specialized stocks, bonds, and derivatives."

                "5.3 Trading In Secondary Markets"-> "Trading in secondary markets refers to the buying and selling of securities after they have been issued in the primary market. Investors trade through brokers or electronic platforms, with the price determined by supply and demand dynamics. The process involves placing buy or sell orders, and once executed, the trade is settled. The secondary market provides liquidity, making it easier for investors to enter or exit positions. Trades are usually executed on exchanges or in over-the-counter markets, depending on the security type and market structure."

                "5.4 What Is The Role Of A Stock Exchange In Secondary Market?" -> "A stock exchange plays a critical role in the secondary market by providing a platform where securities can be bought and sold. It ensures transparency, liquidity, and fairness in trading by establishing rules for listing, trading, and settlement. Stock exchanges facilitate the price discovery process, where supply and demand determine the market value of securities. Additionally, they provide regulatory oversight to prevent market manipulation and maintain investor confidence. Well-known exchanges like the NYSE and Nasdaq offer a regulated environment for buyers and sellers to transact with confidence."

                "5.5 Why Should One Trade On A Recognized Stock Exchange?" -> "Trading on a recognized stock exchange offers several benefits, including increased transparency, security, and regulatory oversight. Recognized exchanges, such as the NYSE or Nasdaq, are governed by strict rules that ensure fair and orderly trading. These exchanges provide liquidity, enabling traders to buy and sell securities quickly at market prices. Additionally, they offer investor protection by requiring listed companies to adhere to reporting and disclosure standards. Trading on a regulated exchange also reduces the risk of fraud and ensures a more stable trading environment compared to unregulated markets."

                "5.6 How To Place Orders With The Brokers" -> "To place orders with brokers, investors first need to establish a trading account with a brokerage firm. Once the account is set up, they can place different types of orders: a **market order**, which buys or sells at the best available price, or a **limit order**, which specifies a maximum or minimum price for the trade. Orders can be placed via phone, online platforms, or mobile apps, depending on the broker's services. Once the order is executed, the broker ensures that the trade is settled, and the securities are transferred to the investor’s account."

                "5.7 Understanding Trading Platforms" -> "Trading platforms are software tools provided by brokerage firms that allow investors to place trades, track portfolio performance, and access market data. These platforms provide real-time market quotes, news, charts, and analysis tools to assist traders in making informed decisions. Most platforms are user-friendly and can be accessed via desktop or mobile devices. They allow traders to place market, limit, and stop-loss orders, manage positions, and monitor the overall market. Some advanced platforms also offer algorithmic trading and custom indicators for experienced traders, making it easier to execute complex strategies."

                "5.8 Getting Started With Trading Platforms" -> "Getting started with trading platforms involves a few simple steps. First, choose a brokerage firm that offers a platform suitable for your trading needs. After opening an account, download the platform or access it online. Most platforms offer demo accounts that allow new traders to practice without real money. Once you’re familiar with the platform, you can fund your account and start trading by selecting securities, placing orders, and managing positions. It’s important to understand how the platform works, including features like order types, margin trading, and risk management tools before you begin real trading."

                "5.9 What Is The Concept Of Brokerage?" -> "Brokerage refers to the fee or commission charged by a broker for facilitating the buying and selling of securities. It can be a flat fee per trade or a percentage of the transaction amount, depending on the broker and the type of trade. Some brokers offer commission-free trades but may make money through other means, such as spreads or account maintenance fees. The cost of brokerage services can vary significantly, and traders should compare brokerage fees before choosing a firm to ensure that they’re getting the best value for their trading needs."

                "5.10 Charges That Comprise of Net Trading Cost?" -> "The net trading cost includes various charges incurred when buying or selling securities. These may include **brokerage fees**, which are the commission charged by the broker; **exchange fees**, which are costs associated with trading on a recognized exchange; **transaction taxes**, such as stamp duty or securities transaction tax (STT), depending on the country; **custodian fees**, for holding securities in a demat account; and **other fees**, such as account maintenance or margin-related charges. Traders should be aware of all these costs to accurately calculate their net trading expenses and assess the profitability of their trades."

            "7.1 What Are The Types Of Derivatives?" -> "Derivatives are financial instruments whose value is based on the price of an underlying asset. The main types include futures contracts, options contracts, swaps, and forwards. Futures are standardized contracts to buy or sell an asset at a predetermined price at a future date. Options give the buyer the right, but not the obligation, to buy or sell an asset at a set price within a specific timeframe. Swaps are agreements between two parties to exchange cash flows, while forwards are customized, over-the-counter contracts similar to futures but without standardization."

            "7.2 Participants In Derivatives Market"-> "The derivatives market includes hedgers, speculators, arbitrageurs, brokers, dealers, and exchanges. Hedgers use derivatives to mitigate the risk of price fluctuations in assets. Speculators seek to profit from market movements, while arbitrageurs exploit price differences in various markets. Brokers and dealers facilitate trades, and exchanges provide platforms for standardized derivative contracts, ensuring liquidity and security. Each participant plays a crucial role in enhancing market efficiency and liquidity, contributing to the overall functioning of the derivatives market."

            "7.3 What Is An Option Premium?"-> "An option premium is the price paid by the buyer to the seller for an options contract. It consists of two components: intrinsic value and extrinsic value. Intrinsic value reflects the difference between the current price of the underlying asset and the strike price if the option is in-the-money. Extrinsic value, or time value, accounts for factors such as time to expiration and market volatility. The premium is influenced by supply and demand, the time left until expiration, and the asset's volatility, reflecting the cost of acquiring the option's rights."

            "7.4 What Is Meant By Commodity?" -> "A commodity is a basic raw material or primary agricultural product that can be bought and sold. Commodities are interchangeable with other products of the same type and are typically traded on exchanges. They are classified into hard commodities, like oil and gold, and soft commodities, such as wheat, coffee, and livestock. Commodities are essential for economic production and are often used as inputs in manufacturing. Their prices are subject to supply and demand dynamics, weather conditions, and geopolitical events, making them important for hedging and investment strategies."
            "8.1 What Is A Depository?" ->"A depository is a financial institution that holds and manages securities in electronic form, enabling safe, easy, and efficient transfer and storage of these securities. It acts as an intermediary between investors and the companies issuing securities. Depositories are responsible for maintaining the records of ownership and ensuring the smooth transfer of securities between buyers and sellers. This eliminates the need for physical certificates, reducing the risks associated with fraud, loss, and theft. By providing electronic holdings, depositories ensure a streamlined process for managing securities, making them integral to the functioning of modern financial markets."
            "8.2 How Is A Depository Similar To A Bank?"-> "A depository is similar to a bank in the sense that it holds and safeguards assets for its clients. Just as a bank holds deposits in the form of money and facilitates transactions, a depository holds financial assets, such as stocks and bonds, and facilitates the transfer and settlement of these securities. Both institutions serve as custodians, offering services like account management, record-keeping, and providing access to assets. However, while banks primarily focus on monetary assets, depositories specialize in electronic records of ownership for securities, playing a crucial role in the capital markets."
            "8.3 Services Provided By A Depository "->"A depository provides several services that are critical to the functioning of financial markets. These include the safekeeping of securities in electronic form, reducing the risk associated with physical certificates. It also facilitates the transfer and settlement of securities, making transactions faster and more efficient. Depositories provide dematerialization and rematerialization services, allowing investors to convert physical certificates into electronic form and vice versa. They also offer services like pledge and hypothecation of securities, corporate actions management, and facilitating the issuance of securities. In short, depositories simplify the management and transaction of financial assets for investors and market participants."
            "8.4 Who Is A Depository Participant?"->"A depository participant (DP) is an intermediary between the depository and investors. DPs are typically banks, financial institutions, or stockbrokers that are authorized to offer depository services to the public. They play a crucial role in the process of dematerialization, rematerialization, and the transfer of securities. Through a DP, investors can open depository accounts (similar to bank accounts) to hold their securities in electronic form. DPs also provide account statements, handle corporate actions like dividend payouts, and assist in executing transactions such as buying or selling securities, all while maintaining a seamless link with the depository."
            "8.5 What Is An ISIN?"->"An ISIN, or International Securities Identification Number, is a unique code that identifies a specific security or financial instrument. It is a 12-character alphanumeric code used to standardize and identify securities across international markets. The ISIN is issued by the local central depository in each country and is used for a variety of purposes, including trading, settlement, and clearing of securities. It ensures that securities can be precisely identified and tracked, avoiding confusion or duplication. The ISIN is crucial for investors and financial institutions to manage and transact securities efficiently, especially in global markets."
            "8.6 What Is A Custodian?"->"A custodian is a financial institution responsible for the safekeeping and protection of financial assets, such as stocks, bonds, and other securities. Custodians provide services like record-keeping, settlement of trades, and handling corporate actions. They ensure that the assets are protected from theft or fraud by maintaining secure electronic or physical storage. Custodians may also manage the collection of income from securities, such as dividends or interest payments. Their role is critical for institutional investors, such as mutual funds or pension funds, as they help ensure that assets are managed according to regulatory standards and client instructions."
            "8.7 Can Electronic Holding Be Converted Into Physical Certificates?"->"Yes, electronic holdings can be converted into physical certificates through a process called rematerialization. Investors who wish to hold their securities in physical form can request their depository participant to initiate the rematerialization process. During this process, the electronic holdings in the investor’s demat account are converted into physical certificates, which are then issued to the investor. This process is typically slower and less common than holding securities in electronic form, as electronic holdings offer greater convenience, security, and faster processing for buying, selling, and transferring securities. However, rematerialization remains an option for those preferring physical certificates."
            "9.1 What Are Mutual Funds?" ->"A mutual fund is an investment program that is professionally managed and diversified in its investments.\n" +
                    "\n" +
                    "The process involves professionals using the funds of retail investors to invest in a carefully selected set of investment products to build a diversified portfolio. The professionals who are responsible for managing a mutual fund are known as fund managers.\n" +
                    "\n" +
                    "A fund manager is an expert who is well versed with how the stock market works. He / She aims to build a portfolio that performs a certain market index.\n" +
                    "\n" +
                    "Suppose you wanted to buy a pizza, but you have money that’s worth half the cost of the pizza. The only solution here would be to find another person, who is interested in buying the other half of the pizza with you.\n" +
                    "\n" +
                    "Why? Because –\n" +
                    "\n" +
                    "The pizza shop will not sell you only half a pizza; and\n" +
                    "Doing so will get you the exact amount of pizza you wanted, at the exact amount of money you wanted to spend.\n" +
                    "Advantages of Mutual Fund\n" +
                    "\n" +
                    "Simple Concept\n" +
                    "The concept and management of a mutual fund investment is very simple. You choose the fund and invest in it, and the rest of the decisions will be handled by the fund managers\n" +
                    "\n" +
                    "Variety of Products\n" +
                    "The mutual fund industry offers a huge number of schemes. They are built to cater to the different types of investors present in the market on the basis of time duration of investments, and the risk appetite of investors\n" +
                    "\n" +
                    "Diversifying our Portfolios\n" +
                    "A mutual fund is a set of different types of investment products. When we put money in a mutual fund, it automatically diversifies your portfolio.\n" +
                    "\n" +
                    "Professional Fund Management\n" +
                    "The biggest advantage of putting our money in a mutual fund comes from the professional management that our investment receives"
                "9.2 Who Is The Regulatory Body For Mutual Funds?" ->"As far as mutual funds are concerned, SEBI formulates policies, regulates and supervises mutual funds to protect the interest of the investors. SEBI notified regulations for mutual funds in 1993. Thereafter, mutual funds sponsored by private sector entities were allowed to enter the capital market. The regulations were fully revised in 1996 and have been amended thereafter from time to time. SEBI has also issued guidelines through circulars to mutual funds from time to time to protect the interests of investors.\n" +
                        "\n" +
                        "All mutual funds whether promoted by public sector or private sector entities including those promoted by foreign entities are governed by the same set of Regulations. There is no distinction in regulatory requirements for these mutual funds and all are subject to monitoring and inspections by SEBI\n" +
                        "\n" +
                        "Association of Mutual Funds in India (AMFI)\n" +
                        "AMFI is an industry-standard organization for all mutual funds of the country. It is a not-for-profit organization that aims to spread investor awareness about the mutual funds industry\n" +
                        "\n" +
                        "Objectives of AMFI\n" +
                        "To outline the ethical and uniform professional standards for every mutual fund operating under the association;\n" +
                        "To encourage its members and investors to maintain ethical business practices and regulations;\n" +
                        "To get AMCs, agents, distributors, advisories and other bodies involved in the capital market to comply with their guidelines;\n" +
                        "To help investors to air their grievances and register complaints against a fund manager or the fund house;\n" +
                        "To distribute information on Mutual Fund Sector and conduct research and workshops on various funds; and\n" +
                        "To spread awareness about the regulations regarding safe mutual fund investments throughout the country\n" +
                        "How Is A Mutual Fund Set Up?\n" +
                        "A mutual fund is set up in the form of a trust, which has sponsor, trustees, Asset Management Company (AMC) and custodian. The trust is established by a sponsor or more than one sponsor who is like promoter of a company. The trustees of the mutual fund hold its property for the benefit of the unitholders. AMC approved by SEBI manages the funds by making investments in various types of securities.\n" +
                        "Custodian, who is required to be registered with SEBI, holds the securities of various schemes of the fund in its custody. The trustees are vested with the general power of superintendence and direction over AMC.\n" +
                        "They monitor the performance and compliance of SEBI Regulations by the mutual fund. SEBI Regulations require that at least two-thirds of the directors of trustee company or board of trustees must be independent i.e. they should not be associated with the sponsors. Also, 50% of the directors of AMC must be independent. All mutual funds are required to be registered with SEBI before they launch any scheme."
                "9.3 What Is NAV?" ->"The performance of a particular scheme of a mutual fund is denoted by Net Asset Value (NAV). Mutual funds invest the money collected from investors in securities markets. In simple words, NAV is the market value of the securities held by the scheme. Since market value of securities changes every day, NAV of a scheme also varies on day to day basis\n" +
                        "The NAV per unit is the market value of securities of a scheme divided by the total number of units of the scheme on any particular date. For example, if the market value of securities of a mutual fund scheme is INR 200 lakh and the mutual fund has issued 10 lakh units of INR 10 each to the investors, then the NAV per unit of the fund is INR 20 (i.e.200 lakh/10 lakh). NAV is required to be disclosed by the mutual funds on a daily basis\n" +
                        "What Are Net Assets Of A Mutual Fund And How Are They Valued?\n" +
                        "The net assets of a mutual fund include all the resources that have been invested into the stocks of the mutual fund scheme.\n" +
                        "\n" +
                        "The Net Assets of a mutual fund are calculated as follows:\n" +
                        "\n" +
                        "\n" +
                        "\n" +
                        "How Frequently Is The NAV Calculated?\n" +
                        "The NAV of every fund is calculated at the end of every market day (business day), on the basis of the closing market prices of the securities that the fund or scheme is invested in. Any changes in the NAV indicate a rise or a dip in the prices of assets of the mutual fund scheme."
                "9.4 Risks Involved In Mutual Funds?" ->"Mutual Funds are subjected to market risk. Read all scheme related documents carefully.” This line is so popular. As we all have heard this in tv ads. So, what this tells us is- Yes, Mutual Funds are subjected to not only market risks but other various types of risks.\n" +
                    "\n" +
                    "Below are some risks involved in Mutual Funds: –\n" +
                    "\n" +
                    "Market Risks\n" +
                    "\n" +
                    "The most known and normal danger for any speculation vehicle is market risk. Market risk is essentially the likelihood that the market or the economy will decrease, making individual speculations lose esteem paying little heed to the exhibition.\n" +
                    "\n" +
                    "Inflation Risks\n" +
                    "\n" +
                    "The danger that increasing financing costs will make your shared assets decrease in esteem. At the point when financing costs rise, security costs decrease and security common assets may likewise decay subsequently. In basic terms, if your shared assets make 10% each year and the typical cost for basic items increases 6% you are simply left with 4% as net returns from your ventures.\n" +
                    "\n" +
                    "Volatility Risk\n" +
                    "\n" +
                    "The risk of losses due to the changes of prices of securities due to the change in the volatility of the market instruments. Market volatility indicates the degree of change of the price of an instrument being traded on the market.\n" +
                    "\n" +
                    "Interest Rate Risks\n" +
                    "\n" +
                    "The risk of the value of fixed-income securities going down due to a rise in the interest rates is known as the interest rate risk.\n" +
                    "\n" +
                    "How Do We Measure The Risks Involved In A Mutual Fund?\n" +
                    "Alpha\n" +
                    "Alpha is the excess returns relative to market benchmark for a given amount of risk taken by the scheme. Put simply, it measures how much better a fund has performed as compared to its benchmark index. For instance, if the NIFTY 50 index delivered 10% in the past year and the fund benchmarked against the NIFTY 50 delivered 11%, then the Alpha is +1%. And if the fund underperformed and achieved only 8%, then the Alpha is -2%.\n" +
                    "\n" +
                    "Therefore, actively managed funds can have positive or negative Alpha depending on how well the fund manager runs the fund. In fact, creating positive Alpha is the entire essence behind someone investing in an actively managed fund. Index Funds, on the other hand, will not produce any Alpha.\n" +
                    "\n" +
                    "Beta\n" +
                    "Beta is a commonly used risk measure and calculates the relative volatility of a stock or Mutual Fund’s returns as against its benchmark. So, Beta merely explains the relative riskiness of an asset and does not give the inherent risk of the asset itself.\n" +
                    "\n" +
                    "Beta is measured against a benchmark. In other words, the default Beta of the stock market or the benchmark will always be the numeric value 1. Since the Mutual Fund returns are measured against the benchmark, the value of Beta can be anything.\n" +
                    "\n" +
                    "For example, if the Beta of a Mutual Fund scheme is 1, it means the fund moves in line with the benchmark. So if the NIFTY 50 moves up by 1%, the fund is likely to go up by 1%. To put it in another way, Index Funds have a Beta of 1.\n" +
                    "\n" +
                    "Likewise, say the Beta of a fund is higher than 1. Assume it is 1.5. So, if the NIFTY 50 jumps by 1%, the fund benchmarked against NIFTY 50 is likely to go up by 1.5%. A similar pattern is followed where the Beta is lower than 1 as well.\n" +
                    "\n" +
                    "Standard Deviation\n" +
                    "The standard deviation measures the dispersion of data from its mean. And from a Mutual Fund perspective, it represents the volatility or riskiness of the fund.\n" +
                    "For instance, let’s say a Mutual Fund delivers 10% average returns over a period of time. But as expected, this fund has had some good months and also some bad months with returns moving between +20% and -15%.\n" +
                    "This up and down trajectory of returns in the Mutual Fund NAV is what standard deviation captures and presents as an annualized number.\n" +
                    "For instance, let’s say this fund that delivers a 10% average return & has a standard deviation of 3%. As a rule of thumb, this means 68% of the time. You can expect the fund’s returns to be between a lower value of 7% (10%-3%) and a higher value of 13% (10% + 3%).\n" +
                    "As a rule, the higher the standard deviation, the more volatile the Mutual Fund on a historical basis. Typically, the Sectoral Funds or Thematic Funds like Banking and Infrastructure Funds and even Small Cap Funds would have a high standard deviation due to the high volatility in annual returns with these funds."
                "9.5 What Are The Different Types of Mutual Funds?" ->"Schemes According To Maturity Period\n" +
                    "A mutual fund scheme can be classified into open-ended scheme or close-ended scheme depending on its maturity period.\n" +
                    "\n" +
                    "Open-ended Fund/Scheme\n" +
                    "An open-ended fund or scheme is one that is available for subscription and repurchase on a continuous basis. These schemes do not have a fixed maturity period. Investors can conveniently buy and sell units at Net Asset Value (NAV) per unit which is declared on a daily basis. The key feature of open-end schemes is liquidity.\n" +
                    "\n" +
                    "Close-ended Fund/Scheme\n" +
                    "A close-ended fund or scheme has a stipulated maturity period e.g. 3-5 years. The fund is open for subscription only during a specified period at the time of launch of the scheme. Investors can invest in the scheme at the time of the new fund offer and thereafter they can buy or sell the units of the scheme on the stock exchanges where the units are listed. In order to provide an exit route to the investors, some close-ended funds give an option of selling back the units to the mutual fund through periodic repurchase at NAV related prices. SEBI Regulations stipulate that at least one of the two exit routes is provided to the investor i.e. either repurchase facility or through listing on stock exchanges\n" +
                    "\n" +
                    "Schemes according to Investment Objective\n" +
                    "A scheme can also be classified as growth scheme, income scheme or balanced scheme considering its investment objective. Such schemes may be open-ended or close-ended schemes as described earlier.\n" +
                    "\n" +
                    "Growth/Equity Oriented Scheme\n" +
                    "The aim of growth funds is to provide capital appreciation over the medium to long- term. Such schemes normally invest a major part of their corpus in equities. Such funds have comparatively high risks. These schemes provide different options to the investors like dividend option, growth, etc. and the investors may choose an option depending on their preferences. The investors must indicate the option in the application form. The mutual funds also allow the investors to change the options at a later date. Growth schemes are good for investors having a long-term outlook seeking appreciation over a period of time.\n" +
                    "\n" +
                    "Income/Debt Oriented Scheme\n" +
                    "The aim of income funds is to provide regular and steady income to investors. Such schemes generally invest in fixed income securities such as bonds, corporate debentures, Government securities and money market instruments. Such funds are less risky compared to equity schemes. However, opportunities of capital appreciation are also limited in such funds. The NAVs of such funds are affected because of change in interest rates in the country. If the interest rates fall, NAVs of such funds are likely to increase in the short run and vice versa. However, long term investors may not bother about these fluctuations.\n" +
                    "\n" +
                    "Balanced/Hybrid Scheme\n" +
                    "The aim of balanced schemes is to provide both growth and regular income as such schemes invest both in equities and fixed income securities in the proportion indicated in their offer documents. These are appropriate for investors looking for moderate growth. They generally invest 40-60% in equity and debt instruments. These funds are also affected because of fluctuations in share prices in the stock markets. However, NAVs of such funds are likely to be less volatile compared to pure equity funds.\n" +
                    "\n" +
                    "Money Market or Liquid Schemes\n" +
                    "These schemes are also income schemes and their aim is to provide easy liquidity, preservation of capital and moderate income. These schemes invest exclusively in short-term instruments such as treasury bills, certificates of deposit, commercial paper and inter-bank call money, government securities, etc. Returns on these schemes fluctuate much less compared with other funds. These funds are appropriate for corporate and individual investors as a means to park their surplus funds for short periods.\n" +
                    "\n" +
                    "Gilt Funds\n" +
                    "These funds invest exclusively in government securities. Government securities have no default risk. NAVs of these schemes also fluctuate due to change in interest rates and other economic factors as is the case with income or debt-oriented schemes.\n" +
                    "\n" +
                    "Index Funds Index\n" +
                    "Funds replicate the portfolio of a particular index such as the BSE Sensitive index (Sensex), NSE 50 index (Nifty), etc. These schemes invest in the securities in the same weightage comprising of an index. NAVs of such schemes would rise or fall in accordance with the rise or fall in the index, though not exactly by the same percentage due to some factors known as “tracking error” in technical terms. Necessary disclosures in this regard are made in the offer document of the mutual fund scheme."
                "9.6 What Are The Rights That Are Available To Mutual Funds Holders In India?" ->"As per SEBI Regulations on Mutual Funds, an investor is entitled to:\n" +
                    "\n" +
                    "Receive Unit certificates or statements of accounts confirming your title within 6 weeks from the date your request for a unit certificate is received by the Mutual Fund.\n" +
                    "Receive information about the investment policies, investment objectives, financial position and general affairs of the scheme\n" +
                    "Receive dividend within 30 days of their declaration and receive the redemption or repurchase proceeds within 10 days from the date of redemption or repurchase.\n" +
                    "The trustees shall be bound to make such disclosures to the unit holders as are essential in order to keep them informed about any information, which may have an adverse bearing on their investments.\n" +
                    "75% of the unit holders with the prior approval of SEBI can terminate the AMC of the fund.\n" +
                    "75% of the unit holders can pass a resolution to wind-up the scheme.\n" +
                    "An investor can send complaints to SEBI, who will take up the matter with the concerned Mutual Funds and follow up with them till they are resolved."
                "9.7 What Is A Fund Offer Document?" ->"The first and foremost document of a mutual fund is standard scheme offer document. The purpose of a scheme offer document is to provide essential information about the scheme in a way that will assist investors in making informed decisions about whether to purchase the units being offered. These Offer document consists of two parts:\n" +
                    "\n" +
                    "Scheme Information Document (SID)\n" +
                    "SID carries important information about the scheme(s) such as their investment objective, asset allocation pattern, investment strategies, risk involved, benchmark indices for respective scheme(s), who will manage the scheme(s), fees & expenses; amongst a host of others for making an informed investment decision.\n" +
                    "\n" +
                    "Statement of Additional Information (SAI)\n" +
                    "SAI contains all statutory information of the Mutual Fund house.\n" +
                    "\n" +
                    "Both SID and SAI are prepared in a format prescribed by the security market regulator SEBI and submitted to it. The content of the document needs to flow in the sequence prescribed in the format.\n" +
                    "In addition, the mutual fund is permitted to add any disclosure which it feels is material for the investor. The other information in SID are dividends and distributions, Inter scheme transfers, Associate transactions, Borrowing by the mutual fund, NAV and Valuation of assets of the scheme, Redemption or repurchase, Accounting policies, Tax treatment, and Investors rights and services are other important aspects."
                "9.8 What Is Active Fund Management?" ->"Active management is the use of human capital to manage a portfolio of funds. Active managers rely on analytical research, personal judgment, and forecasts to make decisions on what securities to buy, hold, or sell.\n" +
                    "Active management is an investment strategy that tries to create excess returns through the recognition, anticipation, and exploitation of short-term investment trends.\n" +
                    "The main intention of extensive activity of buying and selling of assets or securities is to outdo the markets collectively. Active management of investments is targeted at making the most out of the market situation, especially when the markets are on the upward movement.\n" +
                    "Active management of mutual funds involves fund managers juggling across various debt or equity instruments in pursuit of making good profits. However, this is beneficial when the markets are fluctuating."
                "9.9 What Is Passive Fund Management?" ->"Passive management of investments is a method in which the fund managers or the investors implement a laidback approach. This involves tracking a benchmark index to replicate its performance. The primary intention of the passive way of managing investments is to generate returns similar to a benchmark index.\n" +
                    "This can be done by investing in the same securities that the benchmark index is made up of. The idea here is not to outdo the benchmark but to generate returns that are in line with it. Unlike investments that are actively managed, the passively managed investments don’t need a team of experts who regularly track market performance. This is because the securities and assets don’t change frequently.\n" +
                    "The most popular examples of passively managed investments are index mutual funds and exchange-traded funds(ETFs). Here, the fund manager does nothing more than replicating the performance of the benchmark indices being tracked."
                "9.10 What Is An ETF?" ->"ETFs are mutual fund units that investors can buy or sell at the stock exchange. This is in contrast to a normal mutual fund unit that an investor buys or sells from the AMC (directly or through a distributor). In the ETF structure, the AMC does not deal directly with investors or distributors.\n" +
                    "Units are issued to a few designated large participants called Authorised Participants (APs).\n" +
                    "The APs provide buy and sell quotes for the ETFs on the stock exchange, which enable investors to buy and sell the ETFs at any given point of time when the stock markets are open for trading. ETFs therefore trade like stocks and experience price changes throughout the day as they are bought and sold. Buying and selling ETFs requires the investor to have demat and trading accounts"
                "9.11 Must Know Concepts" ->"Expense Ratio\n" +
                    "Expense ratio is the fee that is charged by an Asset Management Company for managing the assets to manage the funds of the investors.\n" +
                    "For instance: An investor invests Rs 100000 and the expense ratio is 2%, then Rs 2000 is used for the expenses involving the management of the fund. The investment companies incur various costs for managing the funds. Some of these include advertisement and promotion costs, fund manager fees, etc.\n" +
                    "AUM stands for assets under management\n" +
                    "A particular fund house has multiple schemes. Every scheme has investors who have invested their money into this. The total of all the investors in all schemes put together is termed as assets under management. It is the total market value of assets that an investment company manages on behalf of its investors\n" +
                    "Exit Load\n" +
                    "Exit load refers to that fee which an investor has to pay for leaving the scheme before a predetermined period. For instance: Suppose, the exit load is 1% for 1 year. It means that the investor will have to shell out 1% of his total investment value if he plans to withdraw his fund before 1 year. After 1 year, no exit load is charged.\n" +
                    "This is basically enacted to ensure that the investor invests for the long term and does not pull out his funds immediately.\n" +
                    "Factsheet\n" +
                    "A factsheet is a document which gives an overview of a mutual fund. It contains the list of securities that the fund has invested in and also contains other data such as 1 year, 3-year, 5 year and since inception returns.\n" +
                    "It also contains the different ratios for example, the sharpe ratio, the point to point returns etc. An investor can go through this sheet to ascertain whether he is invested in the right scheme based on the holdings of that particular fund.\n" +
                    "Benchmark\n" +
                    "A benchmark is a standard against which the performance of a security, a mutual fund or a fund manager can be ascertained. It is a preset list of securities which is used for the comparison with an actual portfolio. Benchmarks are usually broad market indices like BSE Sensex, CNX Nifty which are used to compare the different mutual funds\n" +
                    "Total Return Index\n" +
                    "It is a type of equity index which tracks the capital gains of a group of stocks and assumes that the dividends are added back to the index.\n" +
                    "When we assume this, it means that the dividends that are received from the stock are reinvested back into the same stock from which dividend has been received.\n" +
                    "SIP\n" +
                    "An SIP, or a Systematic Investment Plan is the process of investing periodically be it weekly, fortnightly, monthly or quarterly.\n" +
                    "Here the investment is done irrespective of whether the markets are up or down. In case the NAV is down, more units are purchased and in case the NAV is up, lesser units are bought. This helps in investing over the long term after taking into account the bull run and the bear run.\n" +
                    "It is like an EMI where installments accrue for a specific wealth creation goal. An investor might choose multiple SIPs for different goals. The biggest benefit is that in this one does not need to time the markets.\n" +
                    "SWP\n" +
                    "A Systematic Withdrawal Plan (SWP) w.r.t. to a mutual fund scheme allows an individual to withdraw funds periodically by selling off the proportionate units of the scheme.\n" +
                    "An individual might need monthly cash inflows when he retires or even for other necessary expenses which he incurs on a monthly basis. Therefore, when he puts his money in a mutual fund, and then sets up an SWP on that fund, he will\n" +
                    "receive periodical payments through deductions from the fund. This can serve as an alternate source of income for investors.\n" +
                    "STP\n" +
                    "An STP, short for Systematic Transfer Plan, is a scheme that allows an investor to transfer funds or units from one scheme to another offered by the same mutual fund house.\n" +
                    "An investor can use this system to maintain a balance between their investments in two different segments of the market. This ensures diversification of funds and protects investors from concentration risk as well."
            else -> "Content not available."
        }
    }

    private fun setTopicImage(topic: String?, imageView: ImageView) {
        when (topic) {
            "Investment Basics" -> imageView.setImageResource(R.drawable.introduction_to_margins)
            "Securities" -> imageView.setImageResource(R.drawable.audit_amico)
            "Primary Market" -> imageView.setImageResource(R.drawable.primary_market)
            "IPO Basics" -> imageView.setImageResource(R.drawable.ipo)
            "Secondary Market" -> imageView.setImageResource(R.drawable.secondary_market)
            "Products in Secondary Market" -> imageView.setImageResource(R.drawable.product_dealt_sm)
            "Derivatives" -> imageView.setImageResource(R.drawable.derivatives)
            "Depositories" -> imageView.setImageResource(R.drawable.depositeries)
            "Mutual Funds" -> imageView.setImageResource(R.drawable.mf)
            else -> imageView.setImageResource(R.drawable.logob)
        }
    }
}