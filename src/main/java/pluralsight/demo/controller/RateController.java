package pluralsight.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RefreshScope
public class RateController {

    // pulling data from the config
    @Value("${rate}")
    String rate;

    @Value("${lanecount}")
    String laneCount;

    @Value("${tollstart}")
    String tollStart;

    @Value("${connstring}")
    String connstring;

    @RequestMapping(value = "/rate")
    public String getRate(Model m) {
        m.addAttribute("rateamount", this.rate);
        m.addAttribute("lanes", this.laneCount);
        m.addAttribute("tollStart", this.tollStart);
        m.addAttribute("connstring", this.connstring);

        // name of the view
        return "rateview";
    }
}
