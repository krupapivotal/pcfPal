package io.pivotal.pal.tracker;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

public class EnvController {

    private final String port;
    private final String memory_limit;
    private final String cf_instance_index;
    private final String cf_instance_addr;

    public EnvController(
            @Value("${port:NOT SET}") String port,
            @Value("${memory.limit:NOT SET}") String memoryLimit,
            @Value("${cf.instance.index:NOT SET}") String cfInstanceIndex,
            @Value("${cf.instance.addr:NOT SET}") String cfInstanceAddress
    ) {
        this.port = port;
        this.memory_limit = memoryLimit;
        this.cf_instance_index = cfInstanceIndex;
        this.cf_instance_addr = cfInstanceAddress;
    }


    /*public EnvController(@Value("${PORT:NOT_SET}") String port,
                         @Value("${MEMORY_LIMIT:NOT_SET}")String memory_limit,
                         @Value("${CF_INSTANCE_INDEX:NOT_SET}")String cf_instance_index,
                         @Value("${CF_INSTANCE_ADDR:NOT_SET}")String cf_instance_addr) {
        this.port = port;
        this.memory_limit = memory_limit;
        this.cf_instance_index = cf_instance_index;
        this.cf_instance_addr = cf_instance_addr;
    }*/

    @GetMapping("/env")
    public Map<String,String> getEnv(){
        Map<String,String> env = new HashMap<>();
        env.put("PORT",port);
        env.put("MEMORY_LIMIT",memory_limit);
        env.put("CF_INSTANCE_INDEX",cf_instance_index);
        env.put("CF_INSTANCE_ADDR",cf_instance_addr);

        return env;

    }

    /*
     assertThat(env.get("PORT")).isEqualTo("8675");
        assertThat(env.get("MEMORY_LIMIT")).isEqualTo("12G");
        assertThat(env.get("CF_INSTANCE_INDEX")).isEqualTo("34");
        assertThat(env.get("CF_INSTANCE_ADDR")).isEqualTo("123.sesame.street")
     */
}
