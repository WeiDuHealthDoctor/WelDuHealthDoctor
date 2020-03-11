package com.wd.doctor.presenter;

import com.wd.doctor.base.BasePresenter;
import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.bean.DepartmentBean;
import com.wd.doctor.bean.InquireSickBean;
import com.wd.doctor.bean.PatientBean;
import com.wd.doctor.bean.SickCircleBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.model.IModel;
import com.wd.doctor.view.AnswerActivity;
import com.wd.doctor.view.PictureActivity;
import com.wd.doctor.view.SearchActivity;
import com.wd.doctor.view.ShowActivity;
import com.wd.doctor.view.SickDeatilActivity;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.presenter
 * @ClassName: IPresenter
 * @Author: YuYanHe
 * @CreateDate: 2020/1/8 18:48
 */
public class IPresenter extends BasePresenter {
    IModel model;

    public IPresenter() {
        model = new IModel();
    }

    //查询系统形象照
    public void getAvatars() {
        model.getAvatar(new IContract.IModelAvatar() {
            @Override
            public void avatarsSuccess(AvatarBean avatarBean) {
                ShowActivity showActivity = (ShowActivity) v;
                showActivity.avatarSuccess(avatarBean);
            }
        });
    } //查询系统形象照

    public void getpictureAvatars() {
        model.getAvatar(new IContract.IModelAvatar() {
            @Override
            public void avatarsSuccess(AvatarBean avatarBean) {
                PictureActivity pictureActivity = (PictureActivity) v;
                pictureActivity.avatarSuccess(avatarBean);
            }
        });
    }

    //病友圈列表展示
    public void getPatient(int departmentId, int page, int count) {
        model.getPatient(departmentId, page, count, new IContract.IModelPatient() {
            @Override
            public void patientsSuccess(PatientBean patientBean) {
                AnswerActivity answerActivity = (AnswerActivity) v;
                answerActivity.patientSuccess(patientBean);
            }
        });
    }

    //查询病友圈详情
    public void getSickCirclees(int sickCircleId) {
        model.getSickCrircle(sickCircleId, new IContract.IModelSickCircle() {
            @Override
            public void sickCirclesSuccess(SickCircleBean sickCircleBean) {
                SickDeatilActivity sickDeatilActivity = (SickDeatilActivity) v;
                sickDeatilActivity.sickCircleSuccess(sickCircleBean);
            }
        });
    }

    //查询科室
    public void getDepartment() {
        model.getDepartment(new IContract.IModelDepartment() {
            @Override
            public void departmentesSuccess(DepartmentBean departmentBean) {
                AnswerActivity answerActivitys = (AnswerActivity) v;
                answerActivitys.departmentSuccess(departmentBean);
            }
        });
    }

    //根据关键字查询病友圈
    public void getSearchSickCircle(String keyWord) {
        model.getSearchSick(keyWord, new IContract.IModelInquire() {
            @Override
            public void InquiresSuccess(InquireSickBean inquireSickBean) {
                SearchActivity searchActivity = (SearchActivity) v;
                searchActivity.InquireSuccess(inquireSickBean);
            }
        });
    }
}
