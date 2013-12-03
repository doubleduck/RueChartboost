#ifndef CHARTBOOSTEXT_H
#define CHARTBOOSTEXT_H


namespace ruechartboost
{
	void cbInit(const char *appId, const char *appSignature);
    void cbCacheInterstitial();
    void cbShowInterstitial();
    bool cbHasCachedInterstitial();
}


#endif