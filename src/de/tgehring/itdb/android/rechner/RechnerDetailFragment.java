package de.tgehring.itdb.android.rechner;

import java.util.List;
import java.util.Observable;
import java.util.Observer;

import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import de.tgehring.itdb.android.R;
import de.tgehring.itdb.android.StateHolder;
import de.tgehring.itdb.android.connection.CheckInternetConnection;
import de.tgehring.itdb.android.connection.NetworkUtility;
import de.tgehring.itdb.model.Rechner;
import de.tgehring.itdb.model.cache.RechnerList;
import de.tgehring.itdb.model.json.RechnerParser;
import de.tgehring.itdb.service.ConnectionClient;

public class RechnerDetailFragment extends Fragment implements Observer {

	TextView rechnerInvNummerText;
	TextView rechnerGerNummerText;
	TextView rechnerCpuText;
	TextView rechnerGpuText;
	TextView rechnerRamText;
	TextView rechnerHdd1Text;
	TextView rechnerHdd2Text;
	TextView rechnerHdd3Text;
	TextView rechnerHdd4Text;
	TextView rechnerBenText;
	TextView rechnerIPText;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_rechner_detail,
				container, false);
		initComponents(view);
		return view;
	}

	private void initComponents(View view) {
		rechnerInvNummerText = (TextView) view
				.findViewById(R.id.rechnerInvNummerText);
		rechnerGerNummerText = (TextView) view
				.findViewById(R.id.rechnerGerNummerText);
		rechnerCpuText = (TextView) view.findViewById(R.id.rechnerCpuText);
		rechnerGpuText = (TextView) view.findViewById(R.id.rechnerGpuText);
		rechnerRamText = (TextView) view.findViewById(R.id.rechnerRamText);
		rechnerHdd1Text = (TextView) view.findViewById(R.id.rechnerHdd1Text);
		rechnerHdd2Text = (TextView) view.findViewById(R.id.rechnerHdd2Text);
		rechnerHdd3Text = (TextView) view.findViewById(R.id.rechnerHdd3Text);
		rechnerHdd4Text = (TextView) view.findViewById(R.id.rechnerHdd4Text);
		rechnerBenText = (TextView) view.findViewById(R.id.rechnerBenText);
		rechnerIPText = (TextView) view.findViewById(R.id.rechnerIPText);
		String iNummer = RechnerList.getInstance().getInventarnummer();
		if (iNummer != null && iNummer.length() > 0) {
			if (StateHolder.getInstance().isLoading()) {
				StateHolder.getInstance().addObserver(this);
			} else {
				selectRechner();
			}
		} else if (RechnerList.getInstance().getSelected() != -1) {
			setText(RechnerList.getInstance().getSelected());
		}
	}

	private void selectRechner() {
		List<Rechner> list = RechnerList.getInstance().getList();
		if (list.size() == 0) {
			reloadRechner();
		} else {
			determineRechner(list);
		}
	}

	private void determineRechner(List<Rechner> list) {
		for (Rechner rechner : list) {
			Log.i("RD INFO", "CheckInventarnummer");
			String inventarnummer = String.valueOf(Integer.parseInt(RechnerList
					.getInstance().getInventarnummer()));
			String compare = rechner.getInventarnummer();
			if (inventarnummer.equals(compare)) {
				setText(rechner);
				break;
			}
		}
	}

	private void reloadRechner() {
		final NetworkUtility nwu = new NetworkUtility();
		final Uri rechnerSource = Uri.parse(ConnectionClient.getInstance()
				.getUrl() + "/crud/rechner");
		Thread loader = new Thread() {
			public void run() {
				try {
					Log.i("RD INFO", "CheckInternetConnection");
					if (CheckInternetConnection.check()) {
						Log.i("RD INFO", "Begin to load the resource");
						final String rechner = nwu.get(rechnerSource);
						getActivity().runOnUiThread(new Runnable() {

							@Override
							public void run() {
								Log.i("RD INFO", "Begin to parse the resource");
								RechnerParser rparser = new RechnerParser(
										rechner);
								RechnerList.getInstance().setList(
										rparser.getEntities());
								determineRechner(RechnerList.getInstance().getList());
							}

						});
					} else {
						Toast.makeText(getActivity(),
								"Keine Verbindung zum Server!",
								Toast.LENGTH_SHORT).show();
					}
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		};
		loader.start();
	}

	public void setText(int item) {
		Rechner rechner = RechnerList.getInstance().getList().get(item);
		setText(rechner);
	}

	public void setText(Rechner rechner) {
		rechnerInvNummerText.setText(rechner.getInventarnummer());
		rechnerGerNummerText.setText(rechner.getGerätenummer());
		rechnerCpuText.setText(rechner.getCpu());
		rechnerGpuText.setText(rechner.getGpu());
		rechnerRamText.setText(rechner.getRam());
		rechnerHdd1Text.setText(rechner.getHdd1());
		rechnerHdd2Text.setText(rechner.getHdd2());
		rechnerHdd3Text.setText(rechner.getHdd3());
		rechnerHdd4Text.setText(rechner.getHdd4());
		rechnerBenText.setText(rechner.getBenutzer());
		rechnerIPText.setText(rechner.getIp1());
	}

	@Override
	public void update(Observable observable, Object data) {
		StateHolder state = StateHolder.getInstance();
		if (!state.isLoading()) {
			state.deleteObserver(this);
			selectRechner();
		}
	}

}
