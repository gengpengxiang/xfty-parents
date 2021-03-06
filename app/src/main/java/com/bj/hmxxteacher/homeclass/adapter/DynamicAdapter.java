package com.bj.hmxxteacher.homeclass.adapter;

import android.net.Uri;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bj.hmxxteacher.R;
import com.bj.hmxxteacher.homeclass.model.ClassGuanli;
import com.bj.hmxxteacher.homeclass.model.Dynamic;
import com.bj.hmxxteacher.utils.StringUtils;
import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import static com.bj.hmxxteacher.api.HttpUtilService.BASE_RESOURCE_URL;

public class DynamicAdapter extends BaseQuickAdapter<Dynamic.DataBean,BaseViewHolder> {


    public DynamicAdapter(int layoutResId, @Nullable List<Dynamic.DataBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Dynamic.DataBean item) {

        ImageView ivIcon = helper.getView(R.id.iv_icon);
        Glide.with(mContext).load(BASE_RESOURCE_URL+item.getDongtai_pic()).into(ivIcon);

        SimpleDraweeView svStudentImg = helper.getView(R.id.sv_img);
        SimpleDraweeView svBadgeImg = helper.getView(R.id.sv_badge);

        LinearLayout layoutCommend = helper.getView(R.id.layout_commend);
        LinearLayout layoutBadge = helper.getView(R.id.layout_badge);

        TextView tvStudentName = helper.getView(R.id.tv_name);
        TextView tvTime = helper.getView(R.id.tv_time);
        TextView tvThanks = helper.getView(R.id.tv_thanks);

        TextView tvReason = helper.getView(R.id.tv_commend_reason);
        TextView tvBadgeName = helper.getView(R.id.tv_badge_name);
        TextView tvBadgeDescribe = helper.getView(R.id.tv_badge_describe);

        svStudentImg.setImageURI(BASE_RESOURCE_URL+item.getStudent_pic());
        svBadgeImg.setImageURI(BASE_RESOURCE_URL+item.getDongtai_pic());

        tvStudentName.setText(item.getStudent_name());
        tvTime.setText(item.getDongtai_time());

        tvBadgeName.setText(item.getDongtai_title());
        tvReason.setText(item.getDongtai_title());
        tvBadgeDescribe.setText(item.getHuizhang_shuoming());

        if(item.getDongtai_ganxiestatus().equals("1")){
            tvThanks.setVisibility(View.VISIBLE);
            tvThanks.setText("已感谢老师");
        }

        if (StringUtils.isEmpty(item.getDongtai_ganxiestatus()) || item.getDongtai_ganxiestatus().equals("1")) {
            //holder.tvThanksTeacher.setVisibility(View.GONE);
            tvThanks.setVisibility(View.GONE);

        } else {
            //holder.tvThanksTeacher.setVisibility(View.VISIBLE);
            tvThanks.setVisibility(View.VISIBLE);
        }

        if(item.getDongtai_type().equals("z1")){//点赞类型
            layoutCommend.setVisibility(View.VISIBLE);
            layoutBadge.setVisibility(View.GONE);
        }else {
            layoutBadge.setVisibility(View.VISIBLE);
            layoutCommend.setVisibility(View.GONE);

           /* switch (item.getDongtai_type()) {
                case "3":
                    Uri uri = Uri.parse("res:///" + R.mipmap.ic_badge_behavior);
                    svBadgeImg.setImageURI(uri);
                    break;
                case "4":
                    Uri uri = Uri.parse("res:///" + R.mipmap.ic_badge_science);
                    break;
                case "5":
                    Uri uri = Uri.parse("res:///" + R.mipmap.ic_badge_art);
                    break;
                case "6":
                    Uri uri = Uri.parse("res:///" + R.mipmap.ic_badge_sport);
                    break;
                case "7":
                    Uri uri = Uri.parse("res:///" + R.mipmap.ic_badge_language);
                    break;
                case "6":
                    Uri uri = Uri.parse("res:///" + R.mipmap.ic_badge_sport);
                    break;
            }*/
        }

    }

}
