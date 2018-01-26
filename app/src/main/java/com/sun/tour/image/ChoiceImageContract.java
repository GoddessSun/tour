package com.sun.tour.image;

import com.sun.tour.base.BasePresenter;
import com.sun.tour.base.BaseView;

import java.util.List;

/**
 * Created by hanyg on 2018/1/26.
 */

public class ChoiceImageContract {

    public interface View extends BaseView<Presenter>{

        void setImageResult(List<ImageModel> data);

        void setClickImageResult(String s);
    }

    public interface Presenter extends BasePresenter<View>{

        void findLocalImage();

        void handlerCheckedImage(ImageModel model, List<ImageModel> clickData);
    }
}
