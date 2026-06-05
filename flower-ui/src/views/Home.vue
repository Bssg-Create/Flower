<template>
  <el-container>
    <el-header style="background:#fff;display:flex;align-items:center;justify-content:space-between;box-shadow:0 1px 4px rgba(0,0,0,.08);padding:0 20px;">
      <h2 style="color:#409eff;">Flower</h2>
      <div>
        <el-button type="text" @click="">商品列表</el-button>
        <el-button type="text" @click="">DIY制作</el-button>
        <el-button type="text" @click="">购物车</el-button>
        <el-button type="text" @click="">我的订单</el-button>
        <el-button type="text" @click="">登录</el-button>
      </div>
    </el-header>
    <el-main>
      <div style="background:linear-gradient(135deg,#ffecd2,#fcb69f);border-radius:12px;padding:60px;text-align:center;margin-bottom:30px;">
        <h1 style="font-size:32px;color:#8b4513;">鲜花物语 为爱绽放</h1>
        <p style="font-size:16px;color:#a0522d;margin:12px 0;">全场满199减30 | 新人首单9折</p>
      </div>
      <el-row :gutter="20">
        <el-col :span="6" v-for="n in 4" :key="n">
          <el-card shadow="hover" :body-style="{ padding: '16px' }">
            <div style="height:160px;background:linear-gradient(135deg,#fbc2eb,#a6c1ee);border-radius:8px;margin-bottom:12px;display:flex;align-items:center;justify-content:center;font-size:48px;">
              {{ ['1','2','3','4'][n-1] }}
            </div>
            <div style="font-weight:600;">{{ ['99朵红玫瑰','粉玫瑰花盒','阳光向日葵','白百合花束'][n-1] }}</div>
            <div style="color:#f56c6c;font-size:18px;">{{ [299,199,168,258][n-1] }}</div>
          </el-card>
        </el-col>
      </el-row>
    </el-main>
  </el-container>
</template>