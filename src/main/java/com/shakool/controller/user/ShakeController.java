package com.shakool.controller.user;

import com.shakool.pojo.Plan;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by geekgao on 16-5-2.
 */
@Controller
@RequestMapping("/user")
public class ShakeController {
    public List<Plan> plans = new LinkedList<Plan>();

    /**
     *
     * @param userid 用户id
     * @param spoint 起点
     * @param epoint 终点
     * @param stime 开始时间
     * @param etime 结束时间
     * @return
     */
    @RequestMapping(value = "/shake", method = RequestMethod.GET)
    public @ResponseBody String shake(@RequestParam("userid") String userid, @RequestParam("spoint") String spoint, @RequestParam("epoint") String epoint, @RequestParam("stime") String stime, @RequestParam("etime") String etime) {
        Plan newP = new Plan(userid,spoint,epoint,stime,etime,System.currentTimeMillis());
        if (!plans.contains(newP)) {
            //加入新的计划到队列中
            plans.add(newP);
        }

        List<Plan> result = new LinkedList<Plan>();

        for (Plan p:plans) {
            //超时将计划抛弃
            if (p.getAddTime() - newP.getAddTime() > 1000 * 60 * 30) {
                plans.remove(p);
                continue;
            }

            String uid = p.getUserid();

            if (userid.equals(uid)) {
                continue;
            }

            String sp = p.getSpoint();
            String ep = p.getEpoint();
            String st = p.getStime();
            String et = p.getEtime();

            //全部相同
            if (spoint.equals(sp) && epoint.equals(ep) && stime.equals(st) && etime.equals(et)) {
                result.add(p);
            }
            //起始地点和目的地点相同
            else if (spoint.equals(sp) && epoint.equals(ep)) {
                result.add(p);
            }
            //目的地和到达时间相同
            else if (epoint.equals(ep) && etime.equals(et)) {
                result.add(p);
            }
            //目的地相同
            else if (epoint.equals(ep)) {
                result.add(p);
            }
        }

        if (result.isEmpty()) {
            return "{\"errcode\":\"1\",\"msg\":\"没有用户计划匹配\"}";
        } else {
            JSONObject resultJson = new JSONObject();
            JSONArray array = new JSONArray(result);
            resultJson.put("plans",array);

            return resultJson.toString();
        }
    }
}
