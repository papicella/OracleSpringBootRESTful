package pas.ctp.bluemix.psring.oracle.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import pas.ctp.bluemix.psring.oracle.domain.Dept;

import java.util.List;

@Component
public class DeptService
{
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Dept> getAllDeps()
    {
        List<Dept> deps = jdbcTemplate.query("select * from dept", new BeanPropertyRowMapper<Dept>(Dept.class));

        return deps;
    }
}
