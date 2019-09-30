/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory.xml;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.core.io.Resource;

/**
 * Convenience extension of {@link DefaultListableBeanFactory} that reads bean definitions
 * from an XML document. Delegates to {@link XmlBeanDefinitionReader} underneath; effectively
 * equivalent to using an XmlBeanDefinitionReader with a DefaultListableBeanFactory.<br>
 * <font color="#32CD3266">简单的扩展了{@link DefaultListableBeanFactory},用于从XML文档中读取bean定义.委
 * 派{@link XmlBeanDefinitionReader}进行;实际上和在DefaultListableBeanFactory中使用XmlBeanDefinitionReader是相同的</font><br>
 *
 * <p>The structure, element and attribute names of the required XML document
 * are hard-coded in this class. (Of course a transform could be run if necessary
 * to produce this format). "beans" doesn't need to be the root element of the XML
 * document: This class will parse all bean definition elements in the XML file.<br>
 * <font color="#32CD3266">所需要的XML文档的元素与参数结构使用使用硬编码的方式定义到当前类中.(也就是说,进行转换时必须符合这个结构).
 * XML文档的根源素不是必须为"beans":这个类将会解析XML文件中的全部bean定义</font><br>
 *
 * <p>This class registers each bean definition with the {@link DefaultListableBeanFactory}
 * superclass, and relies on the latter's implementation of the {@link BeanFactory} interface.
 * It supports singletons, prototypes, and references to either of these kinds of bean.
 * See {@code "spring-beans-3.x.xsd"} (or historically, {@code "spring-beans-2.0.dtd"}) for
 * details on options and configuration style.<br>
 * <font color="#32CD3266">这个类依靠超类{@link DefaultListableBeanFactory}对{@link BeanFactory}接口的实现注册全部bean定义.它
 * 支持singletions,prototypes以及references三种之中的任何一种的bean.查看{@code "spring-beans-3.x.xsd"}(或更高版
 * 本,{@code "spring-beans-2.0.dtd"})选项与配置方式的详细信息</font><br>
 *
 * <p><b>For advanced needs, consider using a {@link DefaultListableBeanFactory} with
 * an {@link XmlBeanDefinitionReader}.</b> The latter allows for reading from multiple XML
 * resources and is highly configurable in its actual XML parsing behavior.<br>
 * <font color="#32CD3266"><b>对于高级需求,可以考虑使用在{@link DefaultListableBeanFactory}中使
 * 用{@link XmlBeanDefinitionReader}.</b>后者允许从多个XML资源中加载配置,以及可以高度配置它在解析XML是的实际行为</font><br>
 *
 * <font color="#F83EC7">作为bean工厂的实现,这个类几乎没有做任何工作,而是将全部工作委托给{@link XmlBeanDefinitionReader}进行解
 * 析,并配合本类的父级实现注册</font>
 *
 * @author Rod Johnson
 * @author Juergen Hoeller
 * @author Chris Beams
 * @since 15 April 2001
 * @see org.springframework.beans.factory.support.DefaultListableBeanFactory
 * @see XmlBeanDefinitionReader
 * @deprecated as of Spring 3.1 in favor of {@link DefaultListableBeanFactory} and
 * {@link XmlBeanDefinitionReader} <font color="#32CD3266">在Spring3.1之后,推荐使用{@link DefaultListableBeanFactory}
 * 与{@link XmlBeanDefinitionReader}</font>
 */
@Deprecated
@SuppressWarnings({"serial", "all"})
public class XmlBeanFactory extends DefaultListableBeanFactory {

	private final XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(this);


	/**
	 * Create a new XmlBeanFactory with the given resource,
	 * which must be parsable using DOM.<br>
	 * <font color="#32CD3266">使用给予的资源创建一个新的XmlBeanFactory,所使用的DOM必须是可以解析的</font><br>
	 * @param resource the XML resource to load bean definitions from <font color="#32CD3266">将从这个XML资源文件中加载bena定义</font><br>
	 * @throws BeansException in case of loading or parsing errors <font color="#32CD3266">在加载或解析异常时</font><br>
	 */
	public XmlBeanFactory(Resource resource) throws BeansException {
		this(resource, null);
	}

	/**
	 * Create a new XmlBeanFactory with the given input stream,
	 * which must be parsable using DOM.<br>
	 * <font color="#32CD3266">使用给予的资源创建一个新的XmlBeanFactory,所使用的DOM必须是可以解析的</font><br>
	 * @param resource the XML resource to load bean definitions from <font color="#32CD3266">将从这个XML资源文件中加载bena定义</font><br>
	 * @param parentBeanFactory parent bean factory <font color="#32CD3266">父级bean工厂</font><br>
	 * @throws BeansException in case of loading or parsing errors <font color="#32CD3266">在加载或解析异常时</font><br>
	 */
	public XmlBeanFactory(Resource resource, BeanFactory parentBeanFactory) throws BeansException {
		super(parentBeanFactory);
		this.reader.loadBeanDefinitions(resource);
	}

}
