package com.wd.doctor.model;

import com.wd.doctor.bean.AvatarBean;
import com.wd.doctor.bean.PatientBean;
import com.wd.doctor.contract.IContract;
import com.wd.doctor.utils.HealthDoctor;
import com.wd.doctor.utils.HealthDoctorUtil;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import retrofit2.http.Field;

/**
 * @ProjectName: Health_Doctor
 * @Package: com.wd.doctor.model
 * @ClassName: IModel
 * @Author: YuYanHe
 * @CreateDate: 2020/1/8 18:48
 */
public class IModel {
    //查询系统形象照
    public void getAvatar(IContract.IModelAvatar modelAvatar) {
        HealthDoctorUtil.getInstance().getCreateServer(HealthDoctor.class)
                .getAvatar()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AvatarBean>() {
                    @Override
                    public void accept(AvatarBean avatarBean) throws Exception {
                        modelAvatar.avatarsSuccess(avatarBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }

    //申请入驻
    public void getSettlein(String email, String code, String pwd1, String pwd2, String name
            , String inauguralHospital, int departmentId, int jobTitleId, String personalProfile, String goodField
            , IContract.IModelSettlein modelSettlein) {

    }

    //病友圈列表展示
    public void getPatient(int departmentId, int page, int count, IContract.IModelPatient patient) {
        HealthDoctorUtil.getInstance().getCreateServer(HealthDoctor.class).getPatient(departmentId, page, count)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PatientBean>() {
                    @Override
                    public void accept(PatientBean patientBean) throws Exception {
                        patient.patientsSuccess(patientBean);
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                });
    }
}
