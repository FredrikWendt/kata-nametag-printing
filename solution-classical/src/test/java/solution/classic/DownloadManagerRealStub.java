package solution.classic;

import java.util.Arrays;
import java.util.List;

import com.squeed.kata.nametag.services.PhotoDownloadService;
import com.squeed.kata.nametag.services.PhotoDownloadServiceManager;

public class DownloadManagerRealStub implements PhotoDownloadServiceManager {

	private PhotoDownloadService[] srvcs;

	public DownloadManagerRealStub(PhotoDownloadService... srvcs) {
		this.srvcs = srvcs;
	}

	@Override
	public List<PhotoDownloadService> getDownloadServices() {
		return Arrays.asList(srvcs);
	}

}
