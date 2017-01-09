#!/usr/bin/env groovy

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
    parallel 
    {
    stage('Build') { 
      steps{
        script{
          def mts = new com.marvell.ciutils.MtsUtils(env, steps)
          mts.startBuild()
        }
      }
    }
    
    stage('Compilation & Build') {
      steps{
        parallel 'Compilation':{
          script{
            def mts = new com.marvell.ciutils.MtsUtils(env, steps)
            mts.compilationProcess()
          }
        },
          'Build':{
            script{
              def mts = new com.marvell.ciutils.MtsUtils(env, steps)
              mts.buildProcess()
            }
          }
      }
    }
    }
    stage('Test') {
      steps{
       echo 'MTS Test'
      }
    }

    stage('Deploy') {
      steps{
        echo 'MTS Deploy'
      }
    }
  }
}
