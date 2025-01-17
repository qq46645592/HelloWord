package com.mobile.meishang.core.request;

import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import com.mobile.meishang.MActivity;
import com.mobile.meishang.MApplication;
import com.mobile.meishang.core.loader.HeadLoader;
import com.mobile.meishang.core.network.DefaultNetworkRequest;
import com.mobile.meishang.model.RequestDistribute;
import com.mobile.meishang.model.bean.Head;

public class FavoritesAddRequest implements
		LoaderManager.LoaderCallbacks<Head> {

	private MActivity mLeShiHuiActivity;

	public FavoritesAddRequest(MActivity leShiHuiActivity) {
		this.mLeShiHuiActivity = leShiHuiActivity;
	}

	@Override
	public Loader<Head> onCreateLoader(int arg0, Bundle bundle) {
		StringBuffer urlString = new StringBuffer(MApplication
				.getInstance().getmConfig().urlRootApi);
		urlString.append("?op=collect&act=collect");
		DefaultNetworkRequest mHttpRequest = new DefaultNetworkRequest(
				urlString.toString());
		mHttpRequest.addPostParameter("id", bundle.getString("id"));
		HeadLoader loader = new HeadLoader(
				mLeShiHuiActivity, mHttpRequest);
		loader.setExceptionHandler(mLeShiHuiActivity);
		loader.setIdentit(RequestDistribute.FAVORITES_ADD);
		return loader;
	}

	@Override
	public void onLoadFinished(Loader<Head> arg0,
			Head arg1) {
		if (arg1 != null) {
			mLeShiHuiActivity.updateUI(RequestDistribute.FAVORITES_ADD, arg1);
		}
	}

	@Override
	public void onLoaderReset(Loader<Head> arg0) {
	}

}
