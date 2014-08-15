/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package th.co.geniustree.virgo.server;

import java.security.SecureRandom;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import org.netbeans.api.progress.ProgressUtils;
import org.netbeans.api.server.ServerInstance;
import org.netbeans.spi.server.ServerInstanceProvider;
import org.openide.modules.ModuleInstall;
import org.openide.util.Lookup;
import org.openide.util.lookup.Lookups;
import th.co.geniustree.virgo.server.api.Constants;
import th.co.geniustree.virgo.server.api.StopCommand;

public class Installer extends ModuleInstall {
    static{
        try {
            SSLContext ctx = SSLContext.getInstance("SSL");
            ctx.init(null,new TrustManager[]{new MyEmptyX509TrustManager()}, new SecureRandom());
            SSLContext.setDefault(ctx);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void restored() {
        try {
            SSLContext ctx = SSLContext.getInstance("SSL");
            ctx.init(null,new TrustManager[]{new MyEmptyX509TrustManager()}, new SecureRandom());
            SSLContext.setDefault(ctx);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public boolean closing() {
        Lookup forPath = Lookups.forPath(Constants.VERGO_SERVER_REGISTER_PATH);
        VirgoServerInstanceProvider virgoProvider = (VirgoServerInstanceProvider) forPath.lookup(ServerInstanceProvider.class);
        for (ServerInstance instance : virgoProvider.getInstances()) {
            final StopCommand stopCommand = instance.getLookup().lookup(StopCommand.class);
            if (stopCommand != null) {
                ProgressUtils.showProgressDialogAndRun(new Runnable() {
                    @Override
                    public void run() {
                        stopCommand.stop();
                    }
                }, "Stop virgo.");
            }
        }
        return true;
    }
}
