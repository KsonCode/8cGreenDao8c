package com.example.kson.a8cgreendao;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kson.a8cgreendao.entity.UserEntity;
import com.example.kson.a8cgreendao.greendao.DaoMaster;
import com.example.kson.a8cgreendao.greendao.DaoSession;
import com.example.kson.a8cgreendao.greendao.UserEntityDao;
import com.example.kson.a8cgreendao.utils.GreendaoUtils;

import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }



    /**
     * 添加
     * @param view
     */
    public void add(View view) {
        UserEntity userEntity = new UserEntity();
        userEntity.setName("张三");
        UserEntityDao userEntityDao = GreendaoUtils.getInstance().getDaoSession().getUserEntityDao();
        userEntityDao.insert(userEntity);

    }

    /**
     * shanchu
     * @param view
     */
    public void delete(View view) {
        //第一种全部删除
        UserEntityDao userEntityDao = GreendaoUtils.getInstance().getDaoSession().getUserEntityDao();

//        userEntityDao.deleteAll();//全部删除
        //按照条件删除
        List<UserEntity> userEntitys = userEntityDao.loadAll();

        for (UserEntity userEntity : userEntitys) {
            if (3==userEntity.getId()){
                userEntityDao.delete(userEntity);
            }


        }




    }

    /**
     * 更新，修改
     * @param view
     */
    public void update(View view) {
        UserEntityDao userEntityDao = GreendaoUtils.getInstance().getDaoSession().getUserEntityDao();

        List<UserEntity> userEntities = userEntityDao.loadAll();
        for (UserEntity userEntity : userEntities) {
            if (3==userEntity.getId()){

                userEntity.setName("里斯");
                userEntityDao.update(userEntity);
            }

        }
    }

    /**
     * 查询
     * @param view
     */
    public void query(View view) {
        UserEntityDao userEntityDao = GreendaoUtils.getInstance().getDaoSession().getUserEntityDao();

        //第一种
        List<UserEntity> userEntities = userEntityDao.loadAll();//查询所有
        System.out.println("size:"+userEntities.size());

        for (UserEntity userEntity : userEntities) {

            System.out.println(userEntity.getName());

        }

        //第二种
        List<UserEntity> userEntities1 = userEntityDao.queryRaw("where mallid = ? and name =? ", "2","张三丰");
        System.out.println("usersize:"+userEntities1.size());

        //第三种
        QueryBuilder<UserEntity> studentQueryBuilder = GreendaoUtils.getInstance().getDaoSession()
                .queryBuilder(UserEntity.class)
                .where(UserEntityDao.Properties.Id.eq("2"))
                .orderDesc(UserEntityDao.Properties.Id);
        List<UserEntity> list = studentQueryBuilder.list();
        System.out.println("querylistsize:"+list.size());


    }
}
