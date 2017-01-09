#!/usr/bin/env groovy
import com.marvell.ciutils.MtsUtils

def startBuild(env, steps){
   def mts = new MtsUtils(env, steps)
   mts.startBuild()
}

def compile(env, steps){
   def mts = new MtsUtils(env, steps)
   mts.compilationProcess()
}

def buildMts(env, steps){
   def mts = new MtsUtils(env, steps)
   mts.buildProcess()
}

def installMts(env, steps){
   def mts = new MtsUtils(env, steps)
   mts.installBmImage()
}

def reportMts(env, steps){
   def mts = new MtsUtils(env, steps)
   mts.createReport()
}

def testMts(env, steps){
   def mts = new MtsUtils(env, steps)
   mts.grasTests()
}

def finishMts(env, steps){
   def mts = new MtsUtils(env, steps)
   mts.finishBuild()
}

pipeline {
  agent any
  properties {
        buildDiscarder(logRotator(numToKeepStr:'25'))
    }
  
  parameters {
        stringParam(defaultValue: 'cisco_tesla_bx', description: '', name: 'BOX_NAME')
        stringParam(defaultValue: 'cisco_tesla_bx_v2.3', description: '', name: 'BOX_BRANCH')
        stringParam(defaultValue: 'rlinux_913', description: '', name: 'CORE_BRANCH')
        stringParam(defaultValue: 'build_800', description: '', name: 'MTS_BUILD_SYSTEM_BRANCH')
        stringParam(defaultValue: 'rest_api_800', description: '', name: 'REST_API_BRANCH')
   
        stringParam(defaultValue: 'box', description: '', name: 'BUILD_TYPE')
        stringParam(defaultValue: '10.5.231.5:2016', description: '', name: 'DUT_ip_address1')
        stringParam(defaultValue: '10.5.231.2', description: '', name: 'TFTP_ip_address')
        stringParam(defaultValue: '--internal-version', description: '', name: 'INTERNAL')
        stringParam(defaultValue: '10.5.231.5:2014', description: '', name: 'DUT_ip_address2')
   
        stringParam(defaultValue: '10.5.231.5:2015', description: '', name: 'DUT_ip_address3')
        stringParam(defaultValue: '10.5.231.5:2009', description: '', name: 'DUT_ip_address4')
        stringParam(defaultValue: 'sna_gui_tesla_v2.3', description: '', name: 'SNA_GUI_BRANCH')
        stringParam(defaultValue: 'sna_web_v2.3', description: '', name: 'SNA_WEB_BRANCH')
        stringParam(defaultValue: 'wb_core_gui_01', description: '', name: 'WEB_CORE_GUI_BRANCH')
   
        stringParam(defaultValue: 'cisco_tesla_web', description: '', name: 'BX_WEB_NAME')
        stringParam(defaultValue: 'cisco_tesla_wb_v2.3', description: '', name: 'BX_WEB_BRANCH')
        stringParam(defaultValue: 'YES', description: '', name: 'Tests_Are_Needed')
        stringParam(defaultValue: 'yes', description: '', name: 'Webs_are_separated')
    
    }
  
  stages {
   
    stage('Pre-Build') { 
      steps{
       startBuild(env, steps)
      }
    }
    
    stage('Compilation & Build') {
      steps{
        parallel 'Compilation': {
         compile(env, steps)
        }, 'Build': {
          buildMts(env, steps)
        }
      }
    }
    
    stage('Install & Report') {
      steps{
        parallel 'Install': {
         installMts(env, steps)
        }, 'Report': {
          reportMts(env, steps)
        }
      }
    }
     
    stage('Test & Finish') {
      steps{
        parallel 'Test': {
         testMts(env, steps)
        }, 'Finish': {
          finishMts(env, steps)
        }
      }
    }
  }
}
