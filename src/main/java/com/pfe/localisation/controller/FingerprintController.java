package com.pfe.localisation.controller;

import java.util.ArrayList;
import java.util.List;

import org.geotools.geojson.geom.GeometryJSON;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pfe.localisation.json.ResponseJson;
import com.pfe.localisation.json.WifiItem;
import com.pfe.localisation.object.Fingerprints;
import com.pfe.localisation.object.Pointacces;
import com.pfe.localisation.object.Rssi;
import com.pfe.localisation.object.RssiId;
import com.pfe.localisation.service.FingerprintService;
import com.pfe.localisation.service.IndoorspaceService;
import com.pfe.localisation.service.PointAccesService;
import com.pfe.localisation.service.RssiService;
import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import com.vividsolutions.jts.geom.GeometryFactory;
import com.vividsolutions.jts.geom.Point;
import com.vividsolutions.jts.geom.PrecisionModel;

@Controller
@RequestMapping("/rssi")
public class FingerprintController {
	@Autowired
	private FingerprintService fingerprintService;

	@Autowired
	private IndoorspaceService indoorspaceService;

	@Autowired
	private PointAccesService paService;

	@Autowired
	private RssiService rssiService;

	private JSONObject buildGeometry(Geometry geometry) {
		GeometryJSON gjson = new GeometryJSON();
		Object obj = JSONValue.parse(gjson.toString(geometry));
		JSONObject jsonObj = (JSONObject) obj;
		return jsonObj;
	}

	@RequestMapping(value = "/saveFingerprint", method = RequestMethod.POST, headers = {
			"Content-type=application/json", "Accept=application/json" })
	@ResponseBody
	public ResponseJson saveFingerprint(@RequestBody String se) {
		if (se.isEmpty()) {
			return new ResponseJson(false, "No");
		} else {
			System.out.println(se);
			String rssi = se.substring(se.indexOf("{\"RSSi\":[") + 9,
					se.indexOf("]") - 1);
			System.out.println(rssi);
			String abscisse = se.substring(se.indexOf("\"abscisse\":") + 1,
					se.lastIndexOf(",") - 1);
			System.out.println(abscisse);
			String ordonnee = se.substring(se.indexOf("\"ordonnee\":") + 1,
					se.lastIndexOf("}") - 1);
			System.out.println(ordonnee);
			String sx = abscisse.substring(abscisse.indexOf(":") + 1,
					abscisse.length());
			System.out.println(sx);
			String sy = ordonnee.substring(ordonnee.indexOf(":") + 1,
					ordonnee.length());
			System.out.println(sy);
			double x = Double.parseDouble(sx);
			double y = Double.parseDouble(sy);
			Fingerprints fgr = new Fingerprints();
			GeometryFactory factory = new GeometryFactory(new PrecisionModel(
					PrecisionModel.FLOATING), 4329);
			Point p = factory.createPoint(new Coordinate(x, y));
			fgr.setPosition(p);
			fgr.setIndoorspace(indoorspaceService.findSpaceById(13116));
			fingerprintService.persistFingerprints(fgr);
			String str[] = rssi.split("\\},\\{");
			for (int i = 0; i < str.length; i++) {
				String ap = str[i];

				System.out.println(ap);
				String name = ap.substring(ap.indexOf("\"APName\":") + 10,
						ap.indexOf(",") - 1);
				System.out.println(name);
				String adressMac = ap.substring(
						ap.indexOf("\"AdresseMac\":") + 14,
						ap.lastIndexOf(",") - 1);
				System.out.println(adressMac);
				String force = ap
						.substring(ap.indexOf("\"ForceSignal\":") + 14);
				System.out.println(force);
				Pointacces pa = paService.findByAdresseMac(adressMac);
				if (pa == null) {
					pa = new Pointacces();
					pa.setApName(name);
					pa.setAdressemac(adressMac);
					paService.ajoutAP(pa);
				}
				Rssi rssibd = new Rssi();

				float valrssi = Float.parseFloat(force);

				RssiId rssiId = new RssiId(pa.getIdpointacces(),
						fgr.getIdfingerprints());
				rssibd.setId(rssiId);
				rssibd.setValrssi(valrssi);
				rssiService.persistRSSI(rssibd);
			}
			return new ResponseJson(true, "ok");
		}
	}

	@RequestMapping(value = "/fingerprintlocalization", method = RequestMethod.POST, headers = {
			"Content-type=application/json", "Accept=application/json" })
	@ResponseBody
	public ResponseJson FindPosition(@RequestBody String se) {

		List<WifiItem> Rssi= new ArrayList<WifiItem>();
		if (se.isEmpty()) {
			return new ResponseJson(false,
					"we're still locating you... or perhaps you don't have your wifi  turned on");
		} else {
			System.out.println(se);
			String rssi = se
					.substring(se.indexOf("[") + 2, se.indexOf("]") - 1);
			String pa[] = rssi.split("\\},\\{");
			for (int i = 0; i < pa.length; i++) {
				WifiItem rss =new WifiItem();
				String api = pa[i];

				System.out.println(api);
				String name = api.substring(api.indexOf("\"APName\":") + 10,
						api.indexOf(",") - 1);
				rss.setAPName(name);
				System.out.println(name);
				String adressMac = api.substring(
						api.indexOf("\"AdresseMac\":") + 14,
						api.lastIndexOf(",") - 1);
				System.out.println(adressMac);
				rss.setAdresseMac(adressMac);
				String force = api
						.substring(api.indexOf("\"ForceSignal\":") + 14);
				System.out.println(force);
				float valrssi = Float.parseFloat(force);
				rss.setForceSignal(valrssi);
				Rssi.add(rss);
			}
			
			return new ResponseJson(true, "ok");
		}
	}

	@RequestMapping(value = "/getposition/{id}", method = RequestMethod.GET)
	public @ResponseBody JSONObject getposition(@PathVariable int id) {

		Fingerprints fgr = fingerprintService.findFingerprintsById(id);
		if (fgr != null) {
			JSONObject p = this.buildGeometry(fgr.getPosition());
			return p;
		} else
			return null;

	}

}
