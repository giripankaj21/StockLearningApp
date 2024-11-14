package com.example.ca3

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SubtopicDetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_subtopic_detail)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val subtopicTitle = intent.getStringExtra("subtopicTitle") ?: "Subtopic"
        val subtopicContent = intent.getStringExtra("subtopicContent") ?: "Details not available."
        val subtopicImage = intent.getIntExtra("subtopicImage", R.drawable.logob)
        findViewById<TextView>(R.id.tvSubTopicTitle).text = subtopicTitle
        findViewById<TextView>(R.id.tvSubTopicDescription).text = subtopicContent
        val subtopicImageView = findViewById<ImageView>(R.id.ivSubTopicImage)
        setSubtopicImage(subtopicTitle, subtopicImageView)
    }

    private fun setSubtopicImage(subtopicTitle: String?, imageView: ImageView) {
        when (subtopicTitle) {
            "1.1 What Is Investing & Why Should One Invest?" -> imageView.setImageResource(R.drawable.need_to_invest)
            "1.2 Risk Associated With Investing" -> imageView.setImageResource(R.drawable.risks_associated_with_investing)
            "1.3 When To Start Investing?" -> imageView.setImageResource(R.drawable.when_to_start_investing)
            "1.4 What Care Should One Take While Investing?" -> imageView.setImageResource(R.drawable.care_one_should_take_before_investing)
            "1.5 Types Of Investment Instruments" -> imageView.setImageResource(R.drawable.types_of_investment_instruments)
            "1.6 Saving Or Investment – The Better Option" -> imageView.setImageResource(R.drawable.savings_or_investment)
            "1.7 Where Are The Investments Instruments Traded?" -> imageView.setImageResource(R.drawable.what_are_the_investment_instruments)
            "1.8 What Is An Index?" -> imageView.setImageResource(R.drawable.what_is_an_index)
            "1.9 Types Of Stock Market Indices?" -> imageView.setImageResource(R.drawable.types_of_stock_market_indices)
            "2.1 What Is Meant By Securities?" -> imageView.setImageResource(R.drawable.what_are_securities)
            "2.2 What Is The Function Of The Securities Market?" -> imageView.setImageResource(R.drawable.functions_of_securities_market)
            "2.3 Who Regulates The Securities Market?" -> imageView.setImageResource(R.drawable.who_regulates_securities_market)
            "2.4 What Is SEBI And Its Role?" -> imageView.setImageResource(R.drawable.what_is_sebi_its_role)
            "2.5 Who Are The Participants In The Securities Market?" -> imageView.setImageResource(R.drawable.participants_in_securties_market)
            "2.6 Financial Intermediaries" -> imageView.setImageResource(R.drawable.financial_intermediaries)
            "2.7 Where Are The Segments of The Securities Market?" -> imageView.setImageResource(R.drawable.segments_in_securities_market)
            "3.1 What Is A Primary Market & Functions Of Primary Market" -> imageView.setImageResource(R.drawable.what_is_primary_market)
            "3.2 Different Methods Of Raising Capital In Primary Market?" -> imageView.setImageResource(R.drawable.methods_of_raising_capital_in_primary_market)
            "3.3 Public Issue" -> imageView.setImageResource(R.drawable.what_is_public_issue)
            "3.4 Private Placements" -> imageView.setImageResource(R.drawable.what_is_private_placements)
            "3.5 Rights Offering" -> imageView.setImageResource(R.drawable.what_is_rights_offering)
            "3.6 Bonus Issue" -> imageView.setImageResource(R.drawable.what_is_bonus_issue)
            "3.7 Difference Between Bonus Shares & Rights Issue" -> imageView.setImageResource(R.drawable.difference_between_bonus_shares_and_rights_issue)
            "3.8 Participants in Primary Market" -> imageView.setImageResource(R.drawable.who_are_the_participants_in_primary_market)
            "3.9 Value at which Securities are Issued in Primary Market" -> imageView.setImageResource(R.drawable.different_values_at_which_securities_are_issued)
            "4.1 What Is An IPO & Why Do Companies Go Public?" -> imageView.setImageResource(R.drawable.what_is_initial_public_offering)
            "4.2 Advantages Of Going Public & The Process For An IPO?" -> imageView.setImageResource(R.drawable.advantages_of_going_public)
            "4.3 What Is An IPO Procedure In India?" -> imageView.setImageResource(R.drawable.ipo_procedure_in_india)
            "4.4 Book Building Process v/s Fixed Price Mechanism" -> imageView.setImageResource(R.drawable.book_building_process_vs_fixed_price_mechanism)
            "4.5 How Can Investor Invest In IPOs?" -> imageView.setImageResource(R.drawable.how_can_investors_invest_in_ipo)
            "4.6 How Are Shares Allotted?" -> imageView.setImageResource(R.drawable.process_of_share_allotment_in_ipo)
            "4.7 What Should The Investors Look Into Red Herring Prospectus" -> imageView.setImageResource(R.drawable.why_should_investors_look_at_in_red_hearing_prospectus)
            "5.1 What Is Meant By Secondary Market?" -> imageView.setImageResource(R.drawable.what_is_secondary_market)

            "5.2 Types Of Secondary Market – Exchanges & OTC" -> imageView.setImageResource(R.drawable.where_are_stocks_traded_in_secondary_market)

            "5.3 Trading In Secondary Markets" -> imageView.setImageResource(R.drawable.trading_in_secondary_market)
            "5.4 What Is The Role Of A Stock Exchange In Secondary Market?" -> imageView.setImageResource(R.drawable.what_is_the_role_of_a_stock_exchange_in_secondary_market)

            "5.5 Why Should One Trade On A Recognized Stock Exchange?" -> imageView.setImageResource(R.drawable.why_should_one_trade_on_a_recognized_stock_exchange_only_for_buying_selling_shares)
            "5.6 How To Place Orders With The Brokers" -> imageView.setImageResource(R.drawable.how_to_place_orders_with_the_brokers)

            "5.7 Understanding Trading Platforms" -> imageView.setImageResource(R.drawable.features_of_trading_platforms)
            "5.8 Getting Started With Trading Platforms" -> imageView.setImageResource(R.drawable.getting_started_with_trading_platforms)

            "5.9 What Is The Concept Of Brokerage?" -> imageView.setImageResource(R.drawable.understanding_brokerage_concept)

            "5.10 Charges That Comprise of Net Trading Cost?" -> imageView.setImageResource(R.drawable.charges_that_trading_cost_compromise)

            "6.1 What Are The Products Dealt In Secondary Market?" -> imageView.setImageResource(R.drawable.products_dealt_in_security_market)

            "6.2 Why Should One Invest In Equities In Particular?" -> imageView.setImageResource(R.drawable.why_should_one_invest_in_equity_market)
            "6.3 What Has Been The Average Return On Equities In India?" -> imageView.setImageResource(R.drawable.the_average_return_on_equities_in_india)
            "6.4 What Are The Factors That Influence The Price of A Stock?" -> imageView.setImageResource(R.drawable.what_are_the_factors_that_influence_the_price_of_a_stock)
            "6.5 Difference Between The Term Growth Stock V/s Value Stock?" -> imageView.setImageResource(R.drawable.growth_stock_vs_value_stock)

            "6.6 What Is A Portfolio?" -> imageView.setImageResource(R.drawable.what_is_a_portfolio)

            "6.7 What Is Diversification?" -> imageView.setImageResource(R.drawable.what_is_diversification)
            "6.8 What Are The Advantages Of A Diversified Portfolio?" -> imageView.setImageResource(R.drawable.advantages_of_having_diversified_portfolio)
            "6.9 What Is A Debt Instrument?" -> imageView.setImageResource(R.drawable.what_is_a_debt_instrument)
            "6.10 What Are The Features Of Debt Instruments?" -> imageView.setImageResource(R.drawable.features_of_debt_instrument)
            "7.1 What Are The Types Of Derivatives?" -> imageView.setImageResource(R.drawable.types_of_derivatives)
            "7.2 Participants In Derivatives Market" -> imageView.setImageResource(R.drawable.participant_in_derivative_market)
            "7.3 What Is An Option Premium?" -> imageView.setImageResource(R.drawable.what_is_option_premium)
            "7.4 What Is Meant By Commodity?" -> imageView.setImageResource(R.drawable.what_is_meant_by_commodity)

            "8.1 What Is A Depository?" -> imageView.setImageResource(R.drawable.what_is_depository)

            "8.2 How Is A Depository Similar To A Bank?" -> imageView.setImageResource(R.drawable.how_is_depository_similar_to_bank)

            "8.3 Services Provided By A Depository" -> imageView.setImageResource(R.drawable.service_provided_by_a_depository)

            "8.4 Who Is A Depository Participant?" -> imageView.setImageResource(R.drawable.depository_participant)
            "8.5 What Is An ISIN?" -> imageView.setImageResource(R.drawable.internation_security_identification_number)
            "8.6 What Is A Custodian?" -> imageView.setImageResource(R.drawable.custodian)
            "8.7 Can Electronic Holding Be Converted Into Physical Certificates?" -> imageView.setImageResource(R.drawable.the_process_of_rematerialisation)



            "9.1 What Are Mutual Funds?" -> imageView.setImageResource(R.drawable.mutual_fund)
            "9.2 Who Is The Regulatory Body For Mutual Funds?" ->imageView.setImageResource(R.drawable.regulatory_body_of_mutual_fund)
            "9.3 What Is NAV?" ->imageView.setImageResource(R.drawable.what_is_nav)
            "9.4 Risks Involved In Mutual Funds?" ->imageView.setImageResource(R.drawable.risk_involved_in_mutual_fund)
            "9.5 What Are The Different Types of Mutual Funds?" ->imageView.setImageResource(R.drawable.different_types_of_mutual_funds)
            "9.6 What Are The Rights That Are Available To Mutual Funds Holders In India?" ->imageView.setImageResource(R.drawable.rights_available_to_mutual_fund_holders_in_india)
            "9.7 What Is A Fund Offer Document?" ->imageView.setImageResource(R.drawable.fund_offer_document)
            "9.8 What Is Active Fund Management?" ->imageView.setImageResource(R.drawable.active_fund_managment)
            "9.9 What Is Passive Fund Management?" ->imageView.setImageResource(R.drawable.passive_fund_management)
            "9.10 What Is An ETF?" ->imageView.setImageResource(R.drawable.what_is_an_etf)
            "9.11 Must Know Concepts"->imageView.setImageResource(R.drawable.must_know_concepts)

            else -> imageView.setImageResource(R.drawable.logob)
        }
    }
}