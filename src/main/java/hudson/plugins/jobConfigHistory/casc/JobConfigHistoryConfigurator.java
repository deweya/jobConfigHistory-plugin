package hudson.plugins.jobConfigHistory.casc;

import org.kohsuke.accmod.Restricted;
import org.kohsuke.accmod.restrictions.NoExternalUse;

import hudson.Extension;
import hudson.plugins.jobConfigHistory.JobConfigHistory;
import io.jenkins.plugins.casc.Attribute;
import io.jenkins.plugins.casc.BaseConfigurator;
import io.jenkins.plugins.casc.ConfigurationContext;
import io.jenkins.plugins.casc.ConfiguratorException;
import io.jenkins.plugins.casc.model.CNode;
import io.jenkins.plugins.casc.model.Mapping;

@Extension(optional = true)
@Restricted(NoExternalUse.class)
public class JobConfigHistoryConfigurator extends BaseConfigurator<JobConfigHistory> {
	
    @Override
    public CNode describe(JobConfigHistory instance, ConfigurationContext context) throws Exception {
        Mapping mapping = new Mapping();
        for (Attribute attribute : describe()) {
            mapping.put(attribute.getName(), attribute.describe(instance, context));
        }
        return mapping;
    }

	@Override
	public Class<JobConfigHistory> getTarget() {
		return JobConfigHistory.class;
	}

	@Override
	protected JobConfigHistory instance(Mapping arg0, ConfigurationContext arg1) throws ConfiguratorException {
		return JobConfigHistory.getInstance();
	}

}
