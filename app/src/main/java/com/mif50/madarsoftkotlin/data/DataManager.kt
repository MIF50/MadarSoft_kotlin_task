package com.mif50.madarsoftkotlin.data

import com.mif50.madarsoftkotlin.data.local.db.DbManager
import com.mif50.madarsoftkotlin.data.remote.ApiManager

interface DataManager: ApiManager,DbManager