package com.mashup.patatoinvitation.data.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object ApiProvider {

    private const val baseUrl = "http://ec2-13-124-3-1.ap-northeast-2.compute.amazonaws.com:8080/"

    fun provideRepoApi(): InvitationApi = getRetrofitBuild().create(InvitationApi::class.java)

    fun provideUserApi(): UserApi = getRetrofitBuild().create(UserApi::class.java)

    private fun getRetrofitBuild() = Retrofit.Builder()
        .baseUrl(baseUrl)
        .client(getOkhttpClient())
        // 받은 응답을 옵서버블 형태로 변환해 줍니다.
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        .addConverterFactory(getGsonConverter())
        .build()

    private fun getGsonConverter() = GsonConverterFactory.create()

    private fun getOkhttpClient() = OkHttpClient.Builder().apply {

        //TimeOut 시간을 지정합니다.
        readTimeout(60, TimeUnit.SECONDS)
        connectTimeout(60, TimeUnit.SECONDS)
        writeTimeout(5, TimeUnit.SECONDS)

        // 이 클라이언트를 통해 오고 가는 네트워크 요청/응답을 로그로 표시하도록 합니다.
        addInterceptor(getLoggingInterceptor())
    }.build()

    private fun getLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
}