package pas.ctp.bluemix.psring.oracle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pas.ctp.bluemix.psring.oracle.domain.Dept;
import pas.ctp.bluemix.psring.oracle.service.DeptService;

import java.util.List;

@RestController
public class DeptRest
{
    @Autowired
    DeptService deptService;

    @RequestMapping(value = "/alldeps", method = RequestMethod.GET)
    public List<Dept> allDeps()
    {
        return deptService.getAllDeps();
    }
}
