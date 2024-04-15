
#Fixing errors : not opening with windowsBuilder
if you can not  see design button in java classes classes that has interface(Button ,labels..) ,follow this steps:
try open with --> windowsBuilder Editor
if it's not working 
find classpath in your project and add this line

<classpath>
<classpathentry kind="con" path="org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/JavaSE-17">
		<attributes>
			<attribute name="module" value="true"/>
		</attributes>
	</classpathentry>
</classpath>

now try open with --> windowsBuilder Editor

#Fixing errors : Editor Does Not Contain Main Type
right click and build path --> remove from build path ->right click and build path --> add to build path 

#Fixing errors : libraries error
select all libraries from library package and add to build path
