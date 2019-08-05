package com.bawei.presentor;

import com.bawei.model.IModel;
import com.bawei.view.IView;

import java.lang.ref.WeakReference;

public class BasePresentor {
    protected IModel mModel;
    protected WeakReference<IView> viewReference;
}
