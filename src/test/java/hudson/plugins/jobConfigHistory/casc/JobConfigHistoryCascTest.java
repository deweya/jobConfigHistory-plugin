package hudson.plugins.jobConfigHistory.casc;

import org.junit.Rule;
import org.junit.Test;
import org.jvnet.hudson.test.JenkinsRule;

import io.jenkins.plugins.casc.ConfigurationAsCode;
import io.jenkins.plugins.casc.yaml.YamlSource;

public class JobConfigHistoryCascTest {
	
    @Rule
    public JenkinsRule j = new JenkinsRule();
    
    @Test
    public void configure_job_config_history() throws Exception {
        ConfigurationAsCode.get().configureWith(new YamlSource(getClass().getResourceAsStream("jobConfigHistoryCasc.yaml"), YamlSource.READ_FROM_INPUTSTREAM));
    }
    
    @Test
    public void configure_system_credentials() throws Exception {
        ConfigurationAsCode.get().configureWith(new YamlSource(getClass().getResourceAsStream("SystemCredentialsTest.yaml"), YamlSource.READ_FROM_INPUTSTREAM));
        
    }
}
