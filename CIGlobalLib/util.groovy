/*import groovyx.net.http.RESTClient*/

def call(name){
    echo '''
    _______    _______     ______      ______  ___      ___  ___  ___  
 /" _   "|  /"      \   /    " \    /    " \|"  \    /"  ||"  \/"  | 
(: ( \___) |:        | // ____  \  // ____  \\   \  //  /  \   \  /  
 \/ \      |_____/   )/  /    ) :)/  /    ) :)\\  \/. ./    \\  \/   
 //  \ ___  //      /(: (____/ //(: (____/ //  \.    //     /   /    
(:   _(  _||:  __   \ \        /  \        /    \\   /     /   /     
 \_______) |__|  \___) \"_____/    \"_____/      \__/     |___/      
                                                                    
'''
  /*
  def client = new RESTClient( 'http://artii.herokuapp.com/' )
  def resp = client.get( path : 'make?text=${name}&font=rockbox_' ) // ACME boomerang

  assert resp.status == 200  // HTTP response code; 404 means not found, etc.
  echo resp.getData()  
     */
  }
return this
