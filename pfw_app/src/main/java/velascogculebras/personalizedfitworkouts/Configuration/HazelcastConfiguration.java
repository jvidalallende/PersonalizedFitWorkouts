package velascogculebras.personalizedfitworkouts.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.MapAttributeConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.hazelcast.HazelcastSessionRepository;
import org.springframework.session.hazelcast.PrincipalNameExtractor;
import org.springframework.session.hazelcast.config.annotation.web.http.EnableHazelcastHttpSession;

import java.util.Arrays;


@EnableHazelcastHttpSession
@Configuration
public class HazelcastConfiguration {

    @Bean
    public HazelcastInstance hazelcastInstance() {
        MapAttributeConfig attributeConfig = new MapAttributeConfig()
                .setName(HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE)
                .setExtractor(PrincipalNameExtractor.class.getName());

        Config config = new Config();
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getKubernetesConfig().setEnabled(true)
            .setProperty("service-name", System.getenv().get("HAZELCAST_SERVICE_NAME"));

        config.getMapConfig(HazelcastSessionRepository.DEFAULT_SESSION_MAP_NAME)
                .addMapAttributeConfig(attributeConfig)
                .addMapIndexConfig(new MapIndexConfig(
                        HazelcastSessionRepository.PRINCIPAL_NAME_ATTRIBUTE, false));

        return Hazelcast.newHazelcastInstance(config);
    }
}
