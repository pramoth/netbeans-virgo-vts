/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.geniustree.virgo.vts;

import th.co.geniustree.virgo.vts.api.Constants;
import org.netbeans.spi.server.ServerWizardProvider;
import org.openide.WizardDescriptor;
import org.openide.util.lookup.ServiceProvider;
import th.co.geniustree.virgo.vts.wizard.VirgoWizardIterator;

/**
 *
 * @author Pramoth Suwanpech <pramoth@geniustree.co.th>
 */
@ServiceProvider(service=ServerWizardProvider.class, path="Servers")
public class VirgoServerWizardProvider implements ServerWizardProvider {

    @Override
    public String getDisplayName() {
        return Constants.VIRGO_SERVER_NAME;
    }

    @Override
    public WizardDescriptor.InstantiatingIterator getInstantiatingIterator() {
        return new VirgoWizardIterator();
    }

}
