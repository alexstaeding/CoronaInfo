package org.coronainfo.webscraper

import org.coronainfo.webscraper.scraper.JgehrckeScraper

object Main {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Starting WebScraper")
        val dataList = ArrayList<Region>()
        dataList.add(Region("DE"))
        dataList.add(Region("DE", "BW"))
        dataList.add(Region("DE", "BY"))
        dataList.add(Region("DE", "BE"))
        dataList.add(Region("DE", "BB"))
        dataList.add(Region("DE", "HB"))
        dataList.add(Region("DE", "HH"))
        dataList.add(Region("DE", "HE"))
        dataList.add(Region("DE", "MV"))
        dataList.add(Region("DE", "NI"))
        dataList.add(Region("DE", "NW"))
        dataList.add(Region("DE", "RP"))
        dataList.add(Region("DE", "SL"))
        dataList.add(Region("DE", "SN"))
        dataList.add(Region("DE", "TH"))
        dataList.forEach { region: Region ->
            println(region.toString() + ": " + JgehrckeScraper().getCases(region))
        }
    }
}