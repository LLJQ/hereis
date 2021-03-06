package edu.scu.hereis.controller;

import edu.scu.hereis.entity.Spot;
import edu.scu.hereis.service.SpotService;
import edu.scu.hereis.wxresult.SpotResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Vicent_Chen on 2018/5/11.
 */
@RestController
public class SpotController {

    @Autowired
    private SpotService spotService;

    @RequestMapping("/getSpotsByGPS")
    public List<Spot> getSpotsByGPS(Double gpsLng, Double gpsLat, Double r) {
        // TODO: 验证数据合法性
        List<Spot> spotList = spotService.getSpotsByGPS(gpsLng - r, gpsLng + r, gpsLat - r, gpsLat + r);
        return spotList;
    }

    /**
     * 添加一个热点到数据库
     * @param spot
     */
    @PostMapping("/addSpot")
    public Integer addSpot(Spot spot){

        //添加spot到数据库
        spotService.insertSpot(spot);
        return spotService.getLastInsertId();
    }
}
