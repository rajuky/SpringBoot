layout 'layouts/main.tpl',
        pageTitle: 'Welcome for Ford Credit Account Manager',
        mainBody: contents {
        		div(class: 'col-xs-12 col-sm-9'){
        
        			p(class: 'pull-right visible-xs') {
        				button(type: 'button', class: 'btn btn-primary btn-xs', 'data-toggle':'offcanvas', 'Toggle nav')
        			}	
        			
        			div(class: 'jumbotron') {
            			h1('Welcome')
            			p('An example to show case IBM CI MFA.!!')
						p('User Info: '+userInfo);
            		}        		
            		
            }
            
            
            
            
        }